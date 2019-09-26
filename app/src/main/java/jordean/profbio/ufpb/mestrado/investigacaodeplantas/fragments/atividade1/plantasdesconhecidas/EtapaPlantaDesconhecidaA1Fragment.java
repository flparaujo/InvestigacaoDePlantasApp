package jordean.profbio.ufpb.mestrado.investigacaodeplantas.fragments.atividade1.plantasdesconhecidas;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import jordean.profbio.ufpb.mestrado.investigacaodeplantas.R;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.fragments.atividade1.FinalizacaoAtividade1Fragment;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.ui.model.FotoIdentificacaoModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class EtapaPlantaDesconhecidaA1Fragment extends Fragment {


    private FotoIdentificacaoModel fotoIdentificacaoModel;

    public EtapaPlantaDesconhecidaA1Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        fotoIdentificacaoModel = ViewModelProviders.of(requireActivity()).get(FotoIdentificacaoModel.class);
        fotoIdentificacaoModel.setCaracteristicasPlantaSemGrupo(null);

        EditText caracteristicasPlantaDesconhecida = view.findViewById(R.id.caracteristicas_planta_desconhecida);

        Button proxima = view.findViewById(R.id.button_next7a1);

        proxima.setOnClickListener(v -> {
            fotoIdentificacaoModel.setCaracteristicasPlantaSemGrupo(caracteristicasPlantaDesconhecida.getText().toString());

            FinalizacaoAtividade1Fragment finalizacaoAtividade1Fragment = new FinalizacaoAtividade1Fragment();

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left,
                            R.anim.slide_in_left, R.anim.slide_out_right)
                    .replace(R.id.fragment_container, finalizacaoAtividade1Fragment)
                    .addToBackStack("Questao 7a1")
                    .commit();
        });
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_etapa_planta_desconhecida_a1, container, false);
    }

}
