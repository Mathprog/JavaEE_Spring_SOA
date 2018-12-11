package oc.projet.biblio.client.business.service.impl;

import oc.projet.biblio.client.business.service.OuvrageService;
import oc.projet.biblio.client.consumer.generated.OuvrageWS;
import oc.projet.biblio.client.consumer.ws.OuvrageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;


@Service
public class OuvrageServiceImpl implements OuvrageService{

    @Autowired
    private OuvrageClient ouvrageClient;




    @Override
    public List<OuvrageWS> findAllOuvrage(){
        return this.ouvrageClient.geOuvrageClientRequest();
    }

    @Override
    public OuvrageWS find(int id){
        return this.ouvrageClient.getOuvrageByIdClientRequest(id);
    }


    @Override
    public OuvrageWS createOuvrate(String titre){
        return this.ouvrageClient.getOuvrageCreateClientRequest(titre);
    }


    @Override
    public List<OuvrageWS> findAllWithDispo(){
        return this.ouvrageClient.getOuvrageByDispo();
    }


    @Override
    public List<OuvrageWS> findAllWithNoDispo(){
        return this.ouvrageClient.getOuvrageByNoDispo();
    }


    @Override
    public List<OuvrageWS> findAllByTitreResearch(String titre){
        return this.ouvrageClient.getOuvrageByTitreClientRequest(titre);
    }

    /*private List<OuvrageWS> stringBaseEncoded64 (List<OuvrageWS> ouvrageWSList){
        for(OuvrageWS ouvrageWS : ouvrageWSList){
            if(ouvrageWS.getImageBin() != null){
                String base64DataString = null;
                try {
                    base64DataString = new String(ouvrageWS.getImageBin() , "UTF-8");
                } catch (UnsupportedEncodingException uee){
                    uee.printStackTrace();
                }
                ouvrageWS.setImageBase64DataString(base64DataString);
                ouvrageWS.setImageBin(null);
            }

        }
        return ouvrageWSList;
    }*/

   /* @Bean
    public void setOuvrageClient(OuvrageClient ouvrageClient){
        this.ouvrageClient = ouvrageClient;
    }*/


}
