package jordean.profbio.ufpb.mestrado.investigacaodeplantas.fragments.atividade1;


import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import jordean.profbio.ufpb.mestrado.investigacaodeplantas.R;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.fragments.atividade1.plantae.EtapaReinoPlantaeFragment;

import static android.Manifest.permission.*;

/**
 * A simple {@link Fragment} subclass.
 */
public class DescricaoAtividade1Fragment extends Fragment {


    private Button botaoIniciar;

    private static final String[] PERMISSIONS = {
            ACCESS_NETWORK_STATE,
            INTERNET,
            WRITE_EXTERNAL_STORAGE,
            CAMERA
    };

    public DescricaoAtividade1Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        botaoIniciar = view.findViewById(R.id.botao_iniciar_atividade1);

        if(!hasPermissions(requireContext(), PERMISSIONS)){
            botaoIniciar.setText("Solicitar Permissões (câmera e armazenamento)");
        } else {
            botaoIniciar.setText("Iniciar atividade");
        }

        botaoIniciar.setOnClickListener(v -> {
            if(!hasPermissions(requireContext(), PERMISSIONS)){
                requestPermissions(PERMISSIONS, 1);
            } else {
                EtapaReinoPlantaeFragment etapaReinoPlantaeFragment = new EtapaReinoPlantaeFragment();

                requireActivity().getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.slide_down, R.anim.slide_up)
                        .replace(R.id.fragment_container, etapaReinoPlantaeFragment)
                        .commit();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_descricao_atividade1, container, false);
    }

    public static boolean hasPermissions(Context context, String... permissions) {
        if (context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == 1) {
            if(hasPermissions(requireContext(), PERMISSIONS)) {
                botaoIniciar.setText("Iniciar atividade");
            } else {
                Toast.makeText(requireContext(), "Você não permitiu que o app utilizasse a câmera e/ou" +
                        " o armazenamento externo", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
