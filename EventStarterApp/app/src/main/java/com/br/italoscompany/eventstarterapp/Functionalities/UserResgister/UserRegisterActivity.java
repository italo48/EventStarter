package com.br.italoscompany.eventstarterapp.Functionalities.UserResgister;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.br.italoscompany.eventstarterapp.Functionalities.Login.LoginActivity;
import com.br.italoscompany.eventstarterapp.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static com.br.italoscompany.eventstarterapp.Constants.RESULT_CAMERA;

public class UserRegisterActivity extends AppCompatActivity implements IUserRegister.IView {

    private IUserRegister.IPresenter mrPresenter;

    private ImageView imageViewProfilePicture;
    private EditText editTextNameUser, editTextPasswordUser, editTextEmailUser, editTextLoginUser;
    private Button btnSave, btnCancel;

    private String mCurrentPhotoPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        if (mrPresenter == null)
            mrPresenter = new UserRegisterPresenter(this);

        imageViewProfilePicture = (ImageView) findViewById(R.id.imageAvatar);

        editTextNameUser = (EditText) findViewById(R.id.inputNome);
        editTextEmailUser = (EditText) findViewById(R.id.inputEmail);
        editTextLoginUser = (EditText) findViewById(R.id.inputLogin);
        editTextPasswordUser = (EditText) findViewById(R.id.inputSenha);

        btnSave = (Button) findViewById(R.id.buttonSalvar);
        btnCancel = (Button) findViewById(R.id.buttonCancelar);

        mCurrentPhotoPath = "";

        imageViewProfilePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               getPermissios();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mrPresenter.registerUser(
                        editTextNameUser.getText().toString(),
                        editTextEmailUser.getText().toString(),
                        editTextLoginUser.getText().toString(),
                        editTextPasswordUser.getText().toString(),
                        mCurrentPhotoPath
                );
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLoginActivity();
            }
        });
    }

    public void getPermissios() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }
        else
            dispatchTakePictureIntent();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    dispatchTakePictureIntent();
                } else {
                    Toast.makeText(this, "Não vai funcionar!!!", Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            File photoFile = null;
            try {
                File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
//                File storageDir = this.getDir("images", Context.MODE_PRIVATE);
                photoFile = File.createTempFile("PHOTOAPP", ".jpg", storageDir);
                mCurrentPhotoPath = "file:" + photoFile.getAbsolutePath();

                Toast.makeText(this, mCurrentPhotoPath, Toast.LENGTH_LONG).show();
            }
            catch(IOException ex){
                Toast.makeText(getApplicationContext(), "Erro ao tirar a foto", Toast.LENGTH_SHORT).show();
            }

            if (photoFile != null) {
                Uri fileUri = FileProvider.getUriForFile(
                        this,
                        "com.br.italoscompany.eventstarterapp.fileprovider",
                        photoFile);
//                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                startActivityForResult(takePictureIntent, RESULT_CAMERA);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RESULT_CAMERA && resultCode == RESULT_OK) {
            try {
                ImageView imagem = (ImageView)findViewById(R.id.imageAvatar);
                Bitmap bm1 = BitmapFactory.decodeStream(getContentResolver().openInputStream(Uri.parse(mCurrentPhotoPath)));
                File image = new File(this.getFilesDir(), mCurrentPhotoPath);
                imagem.setImageBitmap(resizeImage(this, bm1, 150, 180));

            }catch(FileNotFoundException fnex){
                Toast.makeText(getApplicationContext(), "Foto não encontrada!", Toast.LENGTH_LONG).show();
            }
        }
    }

    private static Bitmap resizeImage(Context context, Bitmap origin, float newWith, float newHeight) {
        Bitmap newBt = null;
        int w = origin.getWidth();
        int h = origin.getHeight();

        float densityFactor = context.getResources().getDisplayMetrics().density;

        float newW = newWith * densityFactor;
        float newH = newHeight * densityFactor;

        float scalaW = newW / w;
        float scalaH = newH / h;

        Matrix m = new Matrix();
        m.postScale(scalaW, scalaH);

        newBt = Bitmap.createBitmap(origin, 0, 0, w, h, m, true);

        return newBt;
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goLoginActivity() {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }
}
