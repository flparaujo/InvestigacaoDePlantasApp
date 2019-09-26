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
public class Pergunta2Fragment extends Fragment {


    public Pergunta2Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ChaveIdentificacaoModel chaveIdentificacaoModel = ViewModelProviders.of(requireActivity()).get(ChaveIdentificacaoModel.class);
        ImageView imagemPlanta = view.findViewById(R.id.imagem_pergunta2);
        imagemPlanta.setImageResource(chaveIdentificacaoModel.getPlantaEscolhida());

        Button gotoResultadoBriofita = view.findViewById(R.id.goto_resultado_briofita);
        Button gotoPergunta3 = view.findViewById(R.id.goto_pergunta_3);

        gotoResultadoBriofita.setOnClickListener(v -> {
            chaveIdentificacaoModel.setRespostaPergunta2(getString(R.string.resposta_2a));
            chaveIdentificacaoModel.setResultado("Grupo: BRIÓFITAS");

            FinalizacaoAtividade2Fragment finalizacaoAtividade2Fragment = new FinalizacaoAtividade2Fragment();
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.card_flip_right_in, R.anim.card_flip_left_out,
                            R.anim.card_flip_left_in, R.anim.card_flip_right_out)
                    .replace(R.id.fragment_container1, finalizacaoAtividade2Fragment)
                    .addToBackStack("Pergunta 2")
                    .commit();
        });

        gotoPergunta3.setOnClickListener(v -> {
            chaveIdentificacaoModel.setRespostaPergunta2(getString(R.string.resposta_2b));

            Pergunta3Fragment pergunta3Fragment = new Pergunta3Fragment();
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.card_flip_right_in, R.anim.card_flip_left_out,
                            R.anim.card_flip_left_in, R.anim.card_flip_right_out)
                    .replace(R.id.fragment_container1, pergunta3Fragment)
                    .addToBackStack("Pergunta 2")
                    .commit();
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pergunta2, container, false);
    }

}
