package jordean.profbio.ufpb.mestrado.investigacaodeplantas.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.transition.Slide;

import com.avast.android.dialogs.fragment.SimpleDialogFragment;

import jordean.profbio.ufpb.mestrado.investigacaodeplantas.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String URL = "https://docs.google.com/forms/d/e/1FAIpQLSe4gXADVC8alenLxuEIgZUMzx1zsypK3v_8wmW0zMwOY4G_Dw/viewform?vc=0&c=0&w=1";

        CardView botaoAtividades =  findViewById(R.id.botao_atividades);
        CardView botaoQuestoes = findViewById(R.id.botao_questoes);
        CardView botaoAcervo = findViewById(R.id.botao_acervo);

        CardView avaliarApp = findViewById(R.id.botao_avaliar);
        CardView sobreApp = findViewById(R.id.botao_info);

        botaoAtividades.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MenuDeAtividadesActivity.class));
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });

        botaoQuestoes.setOnClickListener(v -> {
            //TODO Código temporário
            final String URL2 = "https://docs.google.com/forms/d/e/1FAIpQLSeQYM7adTKYfExOKyOYzDc-NQjcme97akvCKrvMvvMC2V45RA/viewform?vc=0&c=0&w=1";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(URL2));
            startActivity(intent);
        });

        botaoAcervo.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AcervoActivity.class));
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });

        avaliarApp.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(URL));
            startActivity(intent);
        });

        sobreApp.setOnClickListener(v -> {
            mostratInfo();
        });
    }

    private void mostratInfo() {
        SimpleDialogFragment.createBuilder(this, getSupportFragmentManager()).setTitle("Sobre o app").setMessage("Investigação de Plantas").show();
    }

}
