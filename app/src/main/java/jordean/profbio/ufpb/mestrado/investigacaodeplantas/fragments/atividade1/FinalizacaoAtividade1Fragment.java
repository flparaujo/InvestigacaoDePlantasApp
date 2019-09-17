package jordean.profbio.ufpb.mestrado.investigacaodeplantas.fragments.atividade1;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import jordean.profbio.ufpb.mestrado.investigacaodeplantas.BuildConfig;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.R;
import jordean.profbio.ufpb.mestrado.investigacaodeplantas.ui.model.FotoIdentificacaoModel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FinalizacaoAtividade1Fragment extends Fragment {

    private static final int OFFSET = 50;

    Button enviarEmail;
    Button salvarESair;
    private FotoIdentificacaoModel fotoIdentificacaoModel;

    public FinalizacaoAtividade1Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        fotoIdentificacaoModel = ViewModelProviders.of(requireActivity()).get(FotoIdentificacaoModel.class);

        /* TODO */
        //String size = ""+requireActivity().getSupportFragmentManager().getBackStackEntryCount();
        //Log.i("STACK SIZE", size);
        //exibirResultado();
        /* TODO */

        enviarEmail = view.findViewById(R.id.button_compartilhar_tarefa);
        salvarESair = view.findViewById(R.id.button_finalizar_tarefa);

        enviarEmail.setOnClickListener(v -> {
            compartilharTarefa();
            //createPdf();
            //TODO requireActivity().finish();
        });

        salvarESair.setOnClickListener(v -> {
            requireActivity().finish();
        });

    }

    private void compartilharTarefa() {
        StringBuilder message = new StringBuilder();
        ArrayList<Uri> images = new ArrayList<>();

        message.append("1. Existem organismos do Reino Plantae?");
        if (fotoIdentificacaoModel.isExistemOrganismosDoReinoPlantae() == FotoIdentificacaoModel.SIM) {
            message.append(" Sim\n");
            message.append("a) Foto da vegetação local: ");
            String fotoComVegetacao = fotoIdentificacaoModel.getFotoComVegetacao();
            if (fotoComVegetacao != null) {
                String[] path = fotoComVegetacao.split("/");
                message.append(path[path.length - 1]);
                images.add(getFile(fotoComVegetacao));
            }

            message.append("\n2. Há briófitas no ambiente?");
            if (fotoIdentificacaoModel.isExistemBriofitasNoAmbiente() == FotoIdentificacaoModel.SIM) {
                message.append(" Sim\n");
                message.append("a) Foto das briófitas: ");
                String fotoBriofitas = fotoIdentificacaoModel.getFotoBriofitas();
                if (fotoBriofitas != null) {
                    String[] path = fotoBriofitas.split("/");
                    message.append(path[path.length - 1]);
                    images.add(getFile(fotoBriofitas));
                }
            } else {
                message.append("Não \n");
                message.append("a) Característica das briófitas: ");
                message.append(fotoIdentificacaoModel.getPesquisaSobreBriofitas());
            }

            message.append("\n3. Há pteridófitas no ambiente?");
            if (fotoIdentificacaoModel.isExistemPteridofitasNoAmbiente() == FotoIdentificacaoModel.SIM) {
                message.append(" Sim\n");
                message.append("a) Fotografia das pteridófitas: ");
                String fotoPteridofitas = fotoIdentificacaoModel.getFotoPteridofitas();
                if (fotoPteridofitas != null) {
                    String[] path = fotoPteridofitas.split("/");
                    message.append(path[path.length - 1]);
                    images.add(getFile(fotoPteridofitas));
                }
                message.append("\nb) Fotografia dos soros: ");
                String fotoSoros = fotoIdentificacaoModel.getFotoSoros();
                if (fotoSoros != null) {
                    String[] path = fotoSoros.split("/");
                    message.append(path[path.length - 1]);
                    images.add(getFile(fotoSoros));
                }

                message.append("\nc) Sabe o nome das pteridófitas fotografadas?");
                if (fotoIdentificacaoModel.isSabeONomeDasPteridofitas() == FotoIdentificacaoModel.SIM) {
                    message.append("Sim. ");
                    message.append(fotoIdentificacaoModel.getNomePteridofitasFotografadas());
                } else {
                    message.append("Não\n");
                    message.append("d) Pesquisa sobre espécies de pteridófitas: ");
                    message.append(fotoIdentificacaoModel.getPesquisaEspeciesPteridofitas());
                }
            } else {
                message.append(" Não\n");
                message.append("a) Pesquisa sobre pteridófitas: ");
                message.append(fotoIdentificacaoModel.getPesquisaSobrePteridofitas());
            }

            message.append("\n4. Há gimnospermas no ambiente?");
            if (fotoIdentificacaoModel.isExistemGimnospermasNoAmbiente() == FotoIdentificacaoModel.SIM) {
                message.append(" Sim\n");
                message.append("a) Fotografia das gimnospermas: ");
                String fotoGimnospermas = fotoIdentificacaoModel.getFotoGimnospermas();
                if (fotoGimnospermas != null) {
                    String[] path = fotoGimnospermas.split("/");
                    message.append(path[path.length - 1]);
                    images.add(getFile(fotoGimnospermas));
                }
                message.append("\nb) Fotografia dos estróbilos: ");
                String fotoEstrobilos = fotoIdentificacaoModel.getFotoEstrobilos();
                if (fotoEstrobilos != null) {
                    String[] path = fotoEstrobilos.split("/");
                    message.append(path[path.length - 1]);
                    images.add(getFile(fotoEstrobilos));
                }
            } else {
                message.append(" Não");
            }

            message.append("\n5. Há angiospermas no ambiente?");
            if (fotoIdentificacaoModel.isExistemAngiospermasNoAmbiente() == FotoIdentificacaoModel.SIM) {
                message.append(" Sim\n");
                message.append("a) Fotografia das angiospermas: ");
                String fotoAngiospermas = fotoIdentificacaoModel.getFotoAngiospermas();
                if (fotoAngiospermas != null) {
                    String[] path = fotoAngiospermas.split("/");
                    message.append(path[path.length - 1]);
                    images.add(getFile(fotoAngiospermas));
                }
                message.append("\nb) Fotografia das flores: ");
                String fotoFlores = fotoIdentificacaoModel.getFotoFlores();
                if (fotoFlores != null) {
                    String[] path = fotoFlores.split("/");
                    message.append(path[path.length - 1]);
                    images.add(getFile(fotoFlores));
                }
            } else {
                message.append(" Não");
            }

            message.append("\n6. Há plantas sem grupo?");
            if (fotoIdentificacaoModel.isExistePlantaSemGrupoIdentificado() == FotoIdentificacaoModel.SIM) {
                message.append(" Sim\n");
                message.append("a) Fotografia das plantas cujo grupo não foi identificado: ");
                String fotoPlantasSemGrupo = fotoIdentificacaoModel.getFotoPlantaSemGrupo();
                if (fotoPlantasSemGrupo != null) {
                    String[] path = fotoPlantasSemGrupo.split("/");
                    message.append(path[path.length - 1]);
                    images.add(getFile(fotoPlantasSemGrupo));
                }
                message.append("\nb) Características das plantas com grupo não identificado: ");
                message.append(fotoIdentificacaoModel.getCaracteristicasPlantaSemGrupo());
            } else {
                message.append(" Não");
            }

        } else {
            message.append(" Não\n");
            message.append("\na) Por que não há vegetação nessa área? ");
            message.append(fotoIdentificacaoModel.getMotivoNaoTerOrganismos());
            message.append("\nb) Atividades realizadas no ambiente: ");
            message.append(fotoIdentificacaoModel.getTiposDeAtividadeAmbiente());
            message.append("\nc) Já houve vegetação nesse ambiente? ");
            message.append(fotoIdentificacaoModel.getSobreVegetacoesPassadas());
            message.append("\nd) Características das briófitas: ");
            message.append(fotoIdentificacaoModel.getPesquisaSobreBriofitas());
            message.append("\ne) Características das pteridófitas: ");
            message.append(fotoIdentificacaoModel.getPesquisaSobrePteridofitas());
            message.append("\nf) Pesquisa sobre espécies de pteridófitas: ");
            message.append(fotoIdentificacaoModel.getPesquisaEspeciesPteridofitas());
            message.append("\ng) Características das gimnospermas: ");
            message.append(fotoIdentificacaoModel.getPesquisaGimnospermas());
            message.append("\nh) Características das angiospermas: ");
            message.append(fotoIdentificacaoModel.getPesquisaAngiospermas());
        }

        if (images.isEmpty()) {
            final Intent intent = new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT, message.toString());
            intent.setType("text/plain");
            startActivity(Intent.createChooser(intent, "Compartilhar usando..."));
        } else {
            final Intent intent = new Intent(Intent.ACTION_SEND_MULTIPLE);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.putExtra(Intent.EXTRA_TEXT, message.toString());
            intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, images);
            intent.setType("image/jpg");
            startActivity(Intent.createChooser(intent, "Compartilhar usando..."));
        }

    }

    private Uri getFile(String path) {
        File file = new File(path);
        return FileProvider.getUriForFile(requireContext(), BuildConfig.APPLICATION_ID.concat(".provider"), file);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_finalizacao_atividade1, container, false);

    }

    private Bitmap loadImage(String path) {
        Uri uri = getFile(path);
        Bitmap bit = BitmapFactory.decodeFile(uri.getPath());

        ExifInterface exif = null;
        try {
            exif = new ExifInterface(uri.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (exif != null) {
            int rotation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
            int rotationInDegrees = exifToDegrees(rotation);
            if (rotation != 0) {
                return getResizedBitmap(bit, rotationInDegrees);
            } else {
                return bit;
            }
        } else {
            return bit;
        }


    }

    private static int exifToDegrees(int exifOrientation) {
        if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_90) {
            return 90;
        } else if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_180) {
            return 180;
        } else if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_270) {
            return 270;
        }
        return 0;
    }

    private Bitmap getResizedBitmap(Bitmap bitmap, int rotationInDegrees) {

        // CREATE A MATRIX FOR THE MANIPULATION
        Matrix matrix = new Matrix();
        matrix.preRotate(rotationInDegrees);


        // "RECREATE" THE NEW BITMAP
        Bitmap resizedBitmap = Bitmap.createBitmap(
                bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        //bitmap.recycle();
        return resizedBitmap;
    }

}
