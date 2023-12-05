package com.fob.services;

import com.fob.entities.NFe;
import com.fob.services.impl.NFeAMServiceImpl;
import com.fob.services.impl.NFeRSServiceImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class SelecaoServico {

    @Inject
    NFeRSServiceImpl nFeRSService;
    @Inject
    NFeAMServiceImpl nFeAMService;
    public NFe selecionarServico(String chave) {
        String uf = chave.substring(0, 2);
        return switch (uf) {
            case "12" -> null; //{"uf":"AC", "ext":"do Acre" };
            case "27" -> null; //{"uf":"AL", "ext":"de Alagoas" };
            case "13" -> nFeAMService.consult(chave); //{"uf":"AM", "ext":"do Amazonas" };
            case "16" -> null; //{"uf":"AP", "ext":"do Amapá" };
            case "29" -> null; //{"uf":"BA", "ext":"da Bahia" };
            case "23" -> null; //{"uf":"CE", "ext":"do Ceará" };
            case "53" -> null; //{"uf":"DF", "ext":"do Distrito Federal" };
            case "32" -> null; //{"uf":"ES", "ext":"do Espírito Santo" };
            case "52" -> null; //{"uf":"GO", "ext":"de Goiás" };
            case "21" -> null; //{"uf":"MA", "ext":"do Maranhão" };
            case "31" -> null; //{"uf":"MG", "ext":"do Mato Grosso" };
            case "50" -> null; //{"uf":"MS", "ext":"do Mato Grosso do Sul" };
            case "51" -> null; //{"uf":"MT", "ext":"de Minas Gerais" };
            case "15" -> null; //{"uf":"PA", "ext":"da Paraíba" };
            case "25" -> null; //{"uf":"PB", "ext":"do Paraná" };
            case "26" -> null; //{"uf":"PE", "ext":"de Pernambuco" };
            case "22" -> null; //{"uf":"PI", "ext":"do Piauí" };
            case "41" -> null; //{"uf":"PR", "ext":"do Paraná" };
            case "33" -> null; //{"uf":"RJ", "ext":"do Rio de Janeiro" };
            case "24" -> null; //{"uf":"RN", "ext":"do Rio Grande do Norte" };
            case "11" -> null; //{"uf":"RO", "ext":"de Rondônia" };
            case "14" -> null; //{"uf":"RR", "ext":"de Roraima" };
            case "43" -> nFeRSService.consult(chave); //{"uf":"RS", "ext":"do Rio Grande do Sul" };
            case "42" -> null; //{"uf":"SC", "ext":"de Santa Catarina" };
            case "28" -> null; //{"uf":"SE", "ext":"de Sergipe" };
            case "35" -> null; //{"uf":"SP", "ext":"de São Paulo" };
            case "17" -> null; //{"uf":"TO", "ext":"do Tocantins" };
            default -> throw new IllegalArgumentException("Tipo de serviço desconhecido: ");
        };
    }
}