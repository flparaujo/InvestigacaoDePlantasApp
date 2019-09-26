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
import android.widget.EditText;

import jordean.profbio.ufpb.mestrado.investigacaodeplantas.R;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.fragments.atividade1.gimnospermas.EtapaGimnospermasFragment;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.ui.model.FotoIdentificacaoModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class EtapaNomesPteridofitasAFragment extends Fragment {


    public EtapaNomesPteridofitasAFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        FotoIdentificacaoModel fotoIdentificacaoModel = ViewModelProviders.of(requireActivity()).get(FotoIdentificacaoModel.class);
        fotoIdentificacaoModel.setNomePteridofitasFotografadas(null);

        EditText nomePteridofitas = view.findViewById(R.id.nome_pteridofitas);

        Button proxima = view.findViewById(R.id.button_next4a);

        proxima.setOnClickListener(v -> {
            fotoIdentificacaoModel.setNomePteridofitasFotografadas(nomePteridofitas.getText().toString());

            EtapaGimnospermasFragment etapaGimnospermasFragment = new EtapaGimnospermasFragment();

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left,
                            R.anim.slide_in_left, R.anim.slide_out_right)
                    .replace(R.id.fragment_container, etapaGimnospermasFragment)
                    .addToBackStack("Questao 4a")
                    .commit();
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_etapa_nomes_pteridofitas_a, container, false);

    }

}
