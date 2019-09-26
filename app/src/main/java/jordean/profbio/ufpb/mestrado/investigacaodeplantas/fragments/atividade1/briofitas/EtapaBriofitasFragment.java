package jordean.profbio.ufpb.mestrado.investigacaodeplantas.fragments.atividade1.briofitas;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import jordean.profbio.ufpb.mestrado.investigacaodeplantas.R;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.ui.model.FotoIdentificacaoModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class EtapaBriofitasFragment extends Fragment {

    public EtapaBriofitasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        FotoIdentificacaoModel fotoIdentificacaoModel = ViewModelProviders.of(requireActivity()).get(FotoIdentificacaoModel.class);
        fotoIdentificacaoModel.setExistemBriofitasNoAmbiente(FotoIdentificacaoModel.UNDEFINED);

        Button botaoSim = view.findViewById(R.id.button_sim2);
        Button botaoNao = view.findViewById(R.id.button_nao2);

        botaoSim.setOnClickListener(v -> {
            fotoIdentificacaoModel.setExistemBriofitasNoAmbiente(FotoIdentificacaoModel.SIM);

            EtapaBriofitasAFragment etapaBriofitasAFragment = new EtapaBriofitasAFragment();

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left,
                            R.anim.slide_in_left, R.anim.slide_out_right)
                    .replace(R.id.fragment_container, etapaBriofitasAFragment)
                    .addToBackStack("Questao 2")
                    .commit();
        });

        botaoNao.setOnClickListener(v -> {
            fotoIdentificacaoModel.setExistemBriofitasNoAmbiente(FotoIdentificacaoModel.NAO);

            EtapaBriofitasBFragment etapaBriofitasBFragment = new EtapaBriofitasBFragment();

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left,
                            R.anim.slide_in_left, R.anim.slide_out_right)
                    .replace(R.id.fragment_container, etapaBriofitasBFragment)
                    .addToBackStack("Questao 2")
                    .commit();
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_etapa_briofitas, container, false);

    }

}
