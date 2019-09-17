package jordean.profbio.ufpb.mestrado.investigacaodeplantas.fragments.atividade1.briofitas;


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
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.fragments.atividade1.pteridofitas.EtapaPteridofitasBFragment;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.fragments.atividade1.pteridofitas.EtapaPteridofitasFragment;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.ui.model.FotoIdentificacaoModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class EtapaBriofitasBFragment extends Fragment {


    public EtapaBriofitasBFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        FotoIdentificacaoModel fotoIdentificacaoModel = ViewModelProviders.of(requireActivity()).get(FotoIdentificacaoModel.class);
        fotoIdentificacaoModel.setPesquisaSobreBriofitas(null);

        final String url = "https://www.google.com/search?q=caracteristicas+das+briofitas";

        TextView link = view.findViewById(R.id.link_pesquisa_briofitas);

        link.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            PackageManager packageManager = getActivity().getPackageManager();
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent);
            } else {
                Toast.makeText(requireContext(), "Não foi possível completar a ação", Toast.LENGTH_LONG).show();
            }
        });

        EditText pesquisaBriofitas = view.findViewById(R.id.pesquisa_briofitas);

        Button proxima = view.findViewById(R.id.button_next2b);

        proxima.setOnClickListener(v -> {
            fotoIdentificacaoModel.setPesquisaSobreBriofitas(pesquisaBriofitas.getText().toString());

            if(fotoIdentificacaoModel.isExistemOrganismosDoReinoPlantae() == FotoIdentificacaoModel.SIM) {
                gotoEtapaPteridofitas();
            } else {
                gotoEtapaPteridofitasB();
            }

        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_etapa_briofitas_b, container, false);

    }

    private void gotoEtapaPteridofitasB() {
        EtapaPteridofitasBFragment etapaPteridofitasBFragment = new EtapaPteridofitasBFragment();

        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, etapaPteridofitasBFragment)
                .addToBackStack("Questao 2b")
                .commit();
    }

    private void gotoEtapaPteridofitas() {
        EtapaPteridofitasFragment etapaPteridofitasFragment = new EtapaPteridofitasFragment();

        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, etapaPteridofitasFragment)
                .addToBackStack("Questao 2b")
                .commit();
    }
}
