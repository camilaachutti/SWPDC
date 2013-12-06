package dados;

/**
 *
 * @author cachutti
 */
public enum TipoRelatoEventoEnum {
    
    treBufDdoCco10,//indica que o buffer de dados científicos está 10% de sua capacidade preenchido
    treBufDdoCco90,//indica que o buffer de dados científicos está 90% de sua capacidade preenchido
    treBufDdoHke10,//indica que o buffer de dados de housekeeping está 10% de sua capacidade preenchido
    treBufDdoHke90,//indica que o buffer de dados de housekeeping está 90% de sua capacidade preenchido
    treComOP_CKS,//erro de comando do OBDH (PDC): Valor de checksum inválido
    treComOP_CSC,//erro de comando do OBDH (PDC): CSC inválido (erro de sequenciamento de comandos)
    treComOP_Com,//erro de comando do OBDH (PDC): Comprimento inválido
    treComOP_DI, //erro de comando do OBDH (PDC): Delimitados de início inválido
    treComOP_Dados,//erro de comando do OBDH (PDC): campo de dados inválido
    treComOP_IO, //erro de comando do OBDH (PDC): Identificador do origem inválido 
    treComOP_Timeout,//erro de comando do OBDH (PDC): Timeout
    treComOP_Tipo,//erro de comando do OBDH (PDC): Tipo inválido
    treEndCgaDifPtrCga,// valor de endereço de carga diferent
    treEndIniIguFinDga,// valor de endereço inicial igual ao endereço final de descarga de dados
    treEndIniMaiFinDga,// valor de endereço inicial maior do que endereço final de descarga de dados
    treErrSim, //erro simples na memória SRAM
    treLimMemPri,//Limpeza (preenchimento com 0) da memória principal
    treModOpePDC,//Indica Modo de operação do PDC
    trePtrIniCga,//valoe de enddereço inicial para carga de programa inválido
    trePwrON,//indica que o PDC foi ligado
    treRST,//indica que ocorreu resset no processador
    treStaAlmPDCPOST, //status de alimentacão PDC-POST
    treTtaFoaLim,// Indica que a temperatura do PDC está fora dos limites especificados
    treTtaPDCPOST, //Temperatura interna do PDC-POST
    treVrfMemPrg //Verificcação da Memória do Programa

}
