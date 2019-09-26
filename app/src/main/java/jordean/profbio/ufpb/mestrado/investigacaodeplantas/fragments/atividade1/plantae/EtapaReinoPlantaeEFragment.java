package jordean.profbio.ufpb.mestrado.investigacaodeplantas.fragments.atividade1.plantae;


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
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.fragments.atividade1.briofitas.EtapaBriofitasBFragment;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.ui.model.FotoIdentificacaoModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class EtapaReinoPlantaeEFragment extends Fragment {


    public EtapaReinoPlantaeEFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        FotoIdentificacaoModel fotoIdentificacaoModel = ViewModelProviders.of(requireActivity()).get(FotoIdentificacaoModel.class);

        fotoIdentificacaoModel.setSobreVegetacoesPassadas(null);



        EditText pesquisaPlantasQueJaExistiram = view.findViewById(R.id.pesquisa_plantas_que_ja_existiram);

        Button proxima = view.findViewById(R.id.button_next1e);

        proxima.setOnClickListener(v -> {
            fotoIdentificacaoModel.setSobreVegetacoesPassadas(pesquisaPlantasQueJaExistiram.getText().toString());

            EtapaBriofitasBFragment etapaBriofitasBFragment = new EtapaBriofitasBFragment();

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left,
                            R.anim.slide_in_left, R.anim.slide_out_right)
                    .replace(R.id.fragment_container, etapaBriofitasBFragment)
                    .addToBackStack("Questao 1e")
                    .commit();
        });
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_etapa_reino_plantae_e, container, false);
    }

}
