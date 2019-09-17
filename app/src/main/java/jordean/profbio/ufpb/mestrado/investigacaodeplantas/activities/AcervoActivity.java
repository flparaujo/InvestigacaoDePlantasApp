package jordean.profbio.ufpb.mestrado.investigacaodeplantas.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import jordean.profbio.ufpb.mestrado.investigacaodeplantas.BuildConfig;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.R;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.adapter.AcervoAdapter;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.util.AppStrings;

public class AcervoActivity extends AppCompatActivity {

    ListView listView;
    String[] titulos = {"Botânica", "Conhecendo o Reino Plantae", "Palavras Cruzadas"};
    String[] arquivos = {"biblioteca-16-PDF.pdf", "CONHECENDO_OS_GRUPOS_DO_REINO_PLANTAE.pdf", "Palavras_cruzadas_1.pdf"};
    Integer[] thumbnails = {R.drawable.thumbnail_0, R.drawable.thumbnail_1, R.drawable.thumbnail_cw};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acervo);

        Toolbar toolbar = findViewById(R.id.acervo_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        listView = findViewById(R.id.lista_acervo);

        AcervoAdapter acervoAdapter = new AcervoAdapter(this, titulos, thumbnails);
        listView.setAdapter(acervoAdapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (ActivityCompat.checkSelfPermission(AcervoActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                }
            }
            abrirPDF(arquivos[position]);
        });
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == 1 && ActivityCompat.checkSelfPermission(AcervoActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(AcervoActivity.this, "Não será possível abrir os PDFs sem a permissão" +
                    "de armazenamento externo", Toast.LENGTH_LONG).show();
        }
    }

    private void abrirPDF(String fileName) {
        AssetManager assetManager = getAssets();

        InputStream in = null;
        OutputStream out = null;
        String state = Environment.getExternalStorageState();
        if (!Environment.MEDIA_MOUNTED.equals(state)) {
            Toast.makeText(AcervoActivity.this, "Armazenamento externo indisponível", Toast.LENGTH_SHORT).show();
        }

        File diretorioDoApp = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + AppStrings.NOME_DIRETORIO_APP);
        if (!diretorioDoApp.exists()) {
            diretorioDoApp.mkdir();
        }

        File file = new File(diretorioDoApp + File.separator + fileName);

        try {
            in = assetManager.open(fileName);
            out = new BufferedOutputStream(new FileOutputStream(file));
            copyFile(in, out);
            in.close();
            out.flush();
            out.close();
        } catch (Exception e) {
            Log.e("tag", e.getMessage());
        }
        if (file.exists()) //Checking for the file is exist or not
        {
            Uri path = getFile(file.getAbsolutePath());
            Intent objIntent = new Intent(Intent.ACTION_VIEW);
            objIntent.setDataAndType(path, "application/pdf");
            objIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            Intent intent1 = Intent.createChooser(objIntent, AppStrings.ABRIR_COM);
            try {
                startActivity(intent1);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(AcervoActivity.this, "Activity Not Found Exception ", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(AcervoActivity.this, AppStrings.ARQUIVO_NAO_ENCONTRADO, Toast.LENGTH_SHORT).show();
        }
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
    }

    private Uri getFile(String path) {
        File file = new File(path);
        return FileProvider.getUriForFile(AcervoActivity.this, BuildConfig.APPLICATION_ID.concat(".provider"), file);
    }
}
