package jordean.profbio.ufpb.mestrado.investigacaodeplantas.fragments.atividade2;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import jordean.profbio.ufpb.mestrado.investigacaodeplantas.R;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.ui.model.ChaveIdentificacaoModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class Pergunta5Fragment extends Fragment {


    public Pergunta5Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ChaveIdentificacaoModel chaveIdentificacaoModel = ViewModelProviders.of(requireActivity()).get(ChaveIdentificacaoModel.class);
        ImageView imagemPlanta = view.findViewById(R.id.imagem_pergunta5);
        imagemPlanta.setImageResource(chaveIdentificacaoModel.getPlantaEscolhida());

        Button gotoResultadoAngiosperma = view.findViewById(R.id.goto_resultado_angiosperma);
        Button gotoResultadoGimnosperma = view.findViewById(R.id.goto_resultado_gimnosperma);

        gotoResultadoAngiosperma.setOnClickListener(v -> {
            chaveIdentificacaoModel.setRespostaPergunta5(getString(R.string.resposta_5a));
            chaveIdentificacaoModel.setResultado("Grupo: ANGIOSPERMAS");
            gotoFinalAtividade2();
        });

        gotoResultadoGimnosperma.setOnClickListener(v -> {
            chaveIdentificacaoModel.setRespostaPergunta5(getString(R.string.resposta_5b));
            chaveIdentificacaoModel.setResultado("Grupo: GIMNOSPERMAS");
            gotoFinalAtividade2();
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pergunta5, container, false);
    }


    private void gotoFinalAtividade2() {
        FinalizacaoAtividade2Fragment finalizacaoAtividade2Fragment = new FinalizacaoAtividade2Fragment();
        requireActivity().getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.card_flip_right_in, R.anim.card_flip_left_out,
                        R.anim.card_flip_left_in, R.anim.card_flip_right_out)
                .replace(R.id.fragment_container1, finalizacaoAtividade2Fragment)
                .addToBackStack("Pergunta 5")
                .commit();
    }

}
