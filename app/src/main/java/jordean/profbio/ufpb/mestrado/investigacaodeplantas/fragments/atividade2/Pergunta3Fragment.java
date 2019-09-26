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
public class Pergunta3Fragment extends Fragment {


    public Pergunta3Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ChaveIdentificacaoModel chaveIdentificacaoModel = ViewModelProviders.of(requireActivity()).get(ChaveIdentificacaoModel.class);
        ImageView imagemPlanta = view.findViewById(R.id.imagem_pergunta3);
        imagemPlanta.setImageResource(chaveIdentificacaoModel.getPlantaEscolhida());

        Button gotoPergunta5 = view.findViewById(R.id.goto_pergunta5);
        Button gotoPergunta4 = view.findViewById(R.id.goto_pergunta4);

        gotoPergunta5.setOnClickListener(v -> {
            chaveIdentificacaoModel.setRespostaPergunta3(getString(R.string.resposta_3a));

            Pergunta5Fragment pergunta5Fragment = new Pergunta5Fragment();
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.card_flip_right_in, R.anim.card_flip_left_out,
                            R.anim.card_flip_left_in, R.anim.card_flip_right_out)
                    .replace(R.id.fragment_container1, pergunta5Fragment)
                    .addToBackStack("Pergunta 3")
                    .commit();
        });

        gotoPergunta4.setOnClickListener(v -> {
            chaveIdentificacaoModel.setRespostaPergunta3(getString(R.string.resposta_3b));

            Pergunta4Fragment pergunta4Fragment = new Pergunta4Fragment();
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.card_flip_right_in, R.anim.card_flip_left_out,
                            R.anim.card_flip_left_in, R.anim.card_flip_right_out)
                    .replace(R.id.fragment_container1, pergunta4Fragment)
                    .addToBackStack("Pergunta 3")
                    .commit();
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pergunta3, container, false);
    }

}
