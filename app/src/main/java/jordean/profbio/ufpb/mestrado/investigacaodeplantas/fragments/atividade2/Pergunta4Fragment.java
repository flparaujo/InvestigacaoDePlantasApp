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
public class Pergunta4Fragment extends Fragment {


    public Pergunta4Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ChaveIdentificacaoModel chaveIdentificacaoModel = ViewModelProviders.of(requireActivity()).get(ChaveIdentificacaoModel.class);
        ImageView imagemPlanta = view.findViewById(R.id.imagem_pergunta4);
        imagemPlanta.setImageResource(chaveIdentificacaoModel.getPlantaEscolhida());

        Button gotoResultadoPteridofita = view.findViewById(R.id.goto_resultado_pteridofita);
        Button gotoPergunta5 = view.findViewById(R.id.goto_pergunta_5);

        gotoResultadoPteridofita.setOnClickListener(v -> {
            chaveIdentificacaoModel.setRespostaPergunta4(getString(R.string.resposta_4a));
            chaveIdentificacaoModel.setResultado("Grupo: PTERIDÓFITAS");

            FinalizacaoAtividade2Fragment finalizacaoAtividade2Fragment = new FinalizacaoAtividade2Fragment();
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container1, finalizacaoAtividade2Fragment)
                    .addToBackStack("Pergunta 4")
                    .commit();
        });

        gotoPergunta5.setOnClickListener(v -> {
            chaveIdentificacaoModel.setRespostaPergunta4(getString(R.string.resposta_4b));

            Pergunta5Fragment pergunta5Fragment = new Pergunta5Fragment();
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container1, pergunta5Fragment)
                    .addToBackStack("Pergunta 4")
                    .commit();
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pergunta4, container, false);
    }

}
