package jordean.profbio.ufpb.mestrado.investigacaodeplantas.fragments.atividade1.gimnospermas;


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
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.fragments.atividade1.angiospermas.EtapaAngiospermasFragment;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.ui.model.FotoIdentificacaoModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class EtapaGimnospermasFragment extends Fragment {


    public EtapaGimnospermasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        FotoIdentificacaoModel fotoIdentificacaoModel = ViewModelProviders.of(requireActivity()).get(FotoIdentificacaoModel.class);
        fotoIdentificacaoModel.setExistemGimnospermasNoAmbiente(FotoIdentificacaoModel.UNDEFINED);

        final String url = "https://www.google.com/search?q=gimnospermas";

        TextView link = view.findViewById(R.id.link_pesquisa_gimnospermas);

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

        Button botaoSim = view.findViewById(R.id.button_sim5);
        Button botaoNao = view.findViewById(R.id.button_nao5);

        botaoSim.setOnClickListener(v -> {
            fotoIdentificacaoModel.setExistemGimnospermasNoAmbiente(FotoIdentificacaoModel.SIM);

            EtapaGimnospermasAFragment etapaGimnospermasAFragment = new EtapaGimnospermasAFragment();

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left,
                            R.anim.slide_in_left, R.anim.slide_out_right)
                    .replace(R.id.fragment_container, etapaGimnospermasAFragment)
                    .addToBackStack("Questao 5")
                    .commit();
        });

        botaoNao.setOnClickListener(v -> {
            fotoIdentificacaoModel.setExistemGimnospermasNoAmbiente(FotoIdentificacaoModel.NAO);

            EtapaAngiospermasFragment etapaAngiospermasFragment = new EtapaAngiospermasFragment();

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left,
                            R.anim.slide_in_left, R.anim.slide_out_right)
                    .replace(R.id.fragment_container, etapaAngiospermasFragment)
                    .addToBackStack("Questao 5")
                    .commit();
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_etapa_gimnospermas, container, false);

    }

}
