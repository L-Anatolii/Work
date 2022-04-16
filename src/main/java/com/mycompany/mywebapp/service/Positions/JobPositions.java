package com.mycompany.mywebapp.service.Positions;

public enum JobPositions {
    NACHALNIK_UPRAVLENIYA("Начальник управления"),
    ZAM_NACHALNIKA_UPRAVLENIYA("Заместитель начальника управления"),
    GLAVNII_INJENER("Главный инженер"),
    NACHALNIK_OTP_I_PB("Заместитель главного инженера по ОТ, П и ПБ"),
    NACHALNIK_GKS("Начальник службы (ГКС)"),
    NACHALNIK_VPCH("Начальник части (ВПЧ)"),
    NACHALNIK_ASUA_I_TM("Начальник службы (АСУ,АиТМ)"),
    NACHALNIK_ATS("Начальник службы (АТС)"),
    NACHALNIK_SES("Начальник службы (СЭС)"),
    NACHALNIK_EHZ("Начальник службы (ЭХЗ)"),
    NACHALNIK_LES("Начальник службы (ЛЭС)"),
    NACHALNIK_DS("Начальник службы (ДС)"),
    PREDSEDATEL_PPO("Председатель ППО"),
    NAHCALNIK_CEHA("Начальник цеха"),
    INJENER_PO_EOGO("Инженер по ЭОГО"),
    INJENER_PO_REMONTU("Инженер по ремонту"),
    SLESAR_PO_REMONTU_TU("Слесарь по ремонту ТУ"),
    MASHINIST_TC("Машинист ТК");
    private final String name;

    JobPositions(String name) {
        this.name = name;
    }
}
