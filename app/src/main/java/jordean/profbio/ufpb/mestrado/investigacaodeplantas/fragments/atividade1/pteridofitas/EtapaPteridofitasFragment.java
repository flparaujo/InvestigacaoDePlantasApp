package jordean.profbio.ufpb.mestrado.investigacaodeplantas.fragments.atividade1.pteridofitas;


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
public class EtapaPteridofitasFragment extends Fragment {


    public EtapaPteridofitasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        FotoIdentificacaoModel fotoIdentificacaoModel = ViewModelProviders.of(requireActivity()).get(FotoIdentificacaoModel.class);
        fotoIdentificacaoModel.setExistemPteridofitasNoAmbiente(FotoIdentificacaoModel.UNDEFINED);

        Button botaoSim = view.findViewById(R.id.button_sim3);
        Button botaoNao = view.findViewById(R.id.button_nao3);

        botaoSim.setOnClickListener(v -> {
            fotoIdentificacaoModel.setExistemPteridofitasNoAmbiente(FotoIdentificacaoModel.SIM);

            EtapaPteridofitasAFragment etapaPteridofitasAFragment = new EtapaPteridofitasAFragment();

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left,
                            R.anim.slide_in_left, R.anim.slide_out_right)
                    .replace(R.id.fragment_container, etapaPteridofitasAFragment)
                    .addToBackStack("Questao 3")
                    .commit();
        });

        botaoNao.setOnClickListener(v -> {
            fotoIdentificacaoModel.setExistemPteridofitasNoAmbiente(FotoIdentificacaoModel.NAO);

            EtapaPteridofitasBFragment etapaPteridofitasBFragment = new EtapaPteridofitasBFragment();

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left,
                            R.anim.slide_in_left, R.anim.slide_out_right)
                    .replace(R.id.fragment_container, etapaPteridofitasBFragment)
                    .addToBackStack("Questao 3")
                    .commit();
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_etapa_pteridofitas, container, false);

    }

}
