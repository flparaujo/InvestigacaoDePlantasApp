package jordean.profbio.ufpb.mestrado.investigacaodeplantas.fragments.atividade1.angiospermas;


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
import android.widget.TextView;
import android.widget.Toast;

import jordean.profbio.ufpb.mestrado.investigacaodeplantas.R;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.fragments.atividade1.plantasdesconhecidas.EtapaPlantaDesconhecidaFragment;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.ui.model.FotoIdentificacaoModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class EtapaAngiospermasFragment extends Fragment {


    public EtapaAngiospermasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        FotoIdentificacaoModel fotoIdentificacaoModel = ViewModelProviders.of(requireActivity()).get(FotoIdentificacaoModel.class);
        fotoIdentificacaoModel.setExistemAngiospermasNoAmbiente(FotoIdentificacaoModel.UNDEFINED);

        final String url = "https://www.google.com/search?q=angiospermas";

        TextView link = view.findViewById(R.id.link_pesquisa_angiospermas);

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

        Button botaoSim = view.findViewById(R.id.button_sim6);
        Button botaoNao = view.findViewById(R.id.button_nao6);

        botaoSim.setOnClickListener(v -> {
            fotoIdentificacaoModel.setExistemAngiospermasNoAmbiente(FotoIdentificacaoModel.SIM);

            EtapaAngiospermasAFragment etapaAngiospermasAFragment = new EtapaAngiospermasAFragment();

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, etapaAngiospermasAFragment)
                    .addToBackStack("Questao 6")
                    .commit();
        });

        botaoNao.setOnClickListener(v -> {
            fotoIdentificacaoModel.setExistemAngiospermasNoAmbiente(FotoIdentificacaoModel.NAO);

            EtapaPlantaDesconhecidaFragment etapaPlantaDesconhecidaFragment = new EtapaPlantaDesconhecidaFragment();

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, etapaPlantaDesconhecidaFragment)
                    .addToBackStack("Questao 6")
                    .commit();
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       return inflater.inflate(R.layout.fragment_etapa_angimospermas, container, false);
    }

}
