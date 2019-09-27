package jordean.profbio.ufpb.mestrado.investigacaodeplantas.fragments.atividade1.pteridofitas;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
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
import android.widget.TextView;
import android.widget.Toast;

import jordean.profbio.ufpb.mestrado.investigacaodeplantas.R;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.fragments.atividade1.gimnospermas.EtapaGimnospermasBFragment;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.fragments.atividade1.gimnospermas.EtapaGimnospermasFragment;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.ui.model.FotoIdentificacaoModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class EtapaNomesPteridofitasBFragment extends Fragment {


    public EtapaNomesPteridofitasBFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        FotoIdentificacaoModel fotoIdentificacaoModel = ViewModelProviders.of(requireActivity()).get(FotoIdentificacaoModel.class);
        fotoIdentificacaoModel.setPesquisaEspeciesPteridofitas(null);

        final String URL = "https://www.google.com/search?q=especies+de+pteridofitas";

        TextView link = view.findViewById(R.id.link_pesquisa_nomes_pteridofitas);

        link.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(URL));
            PackageManager packageManager = getActivity().getPackageManager();
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent);
            } else {
                Toast.makeText(requireContext(), "Não foi possível completar a ação", Toast.LENGTH_LONG).show();
            }
        });

        EditText pesquisaNomesPteridofitas = view.findViewById(R.id.pesquisa_nomes_pteridofitas);

        Button proxima = view.findViewById(R.id.button_next4b);

        proxima.setOnClickListener(v -> {
            fotoIdentificacaoModel.setPesquisaEspeciesPteridofitas(pesquisaNomesPteridofitas.getText().toString());

            if(fotoIdentificacaoModel.isExistemOrganismosDoReinoPlantae() == FotoIdentificacaoModel.SIM) {
                gotoEtapaGimnospermas();
            } else {
                gotoEtapaGimnospermasB();
            }

        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_etapa_nomes_pteridofitas_b, container, false);
    }

    private void gotoEtapaGimnospermas() {
        EtapaGimnospermasFragment etapaGimnospermasFragment = new EtapaGimnospermasFragment();

        requireActivity().getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left,
                            R.anim.slide_in_left, R.anim.slide_out_right)
                .replace(R.id.fragment_container, etapaGimnospermasFragment)
                .addToBackStack("Questao 4b")
                .commit();
    }

    private void gotoEtapaGimnospermasB() {
        EtapaGimnospermasBFragment etapaGimnospermasBFragment = new EtapaGimnospermasBFragment();

        requireActivity().getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left,
                            R.anim.slide_in_left, R.anim.slide_out_right)
                .replace(R.id.fragment_container, etapaGimnospermasBFragment)
                .addToBackStack("Questao 4b")
                .commit();
    }

}
