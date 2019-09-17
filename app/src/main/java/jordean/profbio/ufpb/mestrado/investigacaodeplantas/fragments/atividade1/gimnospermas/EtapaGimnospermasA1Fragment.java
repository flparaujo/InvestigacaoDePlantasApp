package jordean.profbio.ufpb.mestrado.investigacaodeplantas.fragments.atividade1.gimnospermas;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import jordean.profbio.ufpb.mestrado.investigacaodeplantas.R;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.fragments.atividade1.TelaFotoFragment;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.fragments.atividade1.angiospermas.EtapaAngiospermasFragment;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.ui.model.FotoIdentificacaoModel;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.util.AppStrings;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class EtapaGimnospermasA1Fragment extends TelaFotoFragment {


    private FotoIdentificacaoModel fotoIdentificacaoModel;
    private ImageView imageEstrobilos;

    public EtapaGimnospermasA1Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        fotoIdentificacaoModel = ViewModelProviders.of(requireActivity()).get(FotoIdentificacaoModel.class);
        fotoIdentificacaoModel.setFotoEstrobilos(null);

        imageEstrobilos = view.findViewById(R.id.image_estrobilos);

        imageEstrobilos.setOnClickListener(v -> openCamera(CAMERA_ACTION_PICK_REQUEST_CODE_1));

        Button proxima = view.findViewById(R.id.button_next5a1);

        proxima.setOnClickListener(v -> {
            EtapaAngiospermasFragment etapaAngiospermasFragment = new EtapaAngiospermasFragment();

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, etapaAngiospermasFragment)
                    .addToBackStack("Questao 5a1")
                    .commit();
        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_etapa_gimnospermas_a1, container, false);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == CAMERA_ACTION_PICK_REQUEST_CODE_1 && resultCode == RESULT_OK && data != null) {
            String imagePath = data.getStringExtra("file_name");
            fotoIdentificacaoModel.setFotoEstrobilos(imagePath);
            loadImage(imagePath, imageEstrobilos);
        } else if(resultCode == 1 || resultCode == 2){
            Toast.makeText(requireContext(), AppStrings.ERRO_TIRAR_FOTO, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(requireContext(), AppStrings.FOTO_NAO_TIRADA, Toast.LENGTH_LONG).show();
        }
    }

}