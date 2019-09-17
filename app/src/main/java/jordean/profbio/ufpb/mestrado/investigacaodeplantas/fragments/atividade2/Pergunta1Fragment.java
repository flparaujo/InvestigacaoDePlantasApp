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
public class Pergunta1Fragment extends Fragment {


    public Pergunta1Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ChaveIdentificacaoModel chaveIdentificacaoModel = ViewModelProviders.of(requireActivity()).get(ChaveIdentificacaoModel.class);
        ImageView imagemPlanta = view.findViewById(R.id.imagem_pergunta1);
        imagemPlanta.setImageResource(chaveIdentificacaoModel.getPlantaEscolhida());

        Button gotoPergunta2 = view.findViewById(R.id.goto_pergunta2);
        Button gotoPergunta3 = view.findViewById(R.id.goto_pergunta3);

        gotoPergunta2.setOnClickListener(v -> {
            chaveIdentificacaoModel.setRespostaPergunta1(getString(R.string.resposta_1a));

            Pergunta2Fragment pergunta2Fragment = new Pergunta2Fragment();
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container1, pergunta2Fragment)
                    .addToBackStack("Pergunta 1")
                    .commit();
        });

        gotoPergunta3.setOnClickListener(v -> {
            chaveIdentificacaoModel.setRespostaPergunta1(getString(R.string.resposta_1b));

            Pergunta3Fragment pergunta3Fragment = new Pergunta3Fragment();
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container1, pergunta3Fragment)
                    .addToBackStack("Pergunta 1")
                    .commit();
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pergunta1, container, false);
    }

}
