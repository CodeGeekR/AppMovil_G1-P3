package com.grupounoptresunal.kamaleon.data.mocks

import com.grupounoptresunal.kamaleon.data.models.StoreInfo

class StoreInfoMock {
    fun loadInfo (): StoreInfo{
        return  StoreInfo("1","Kamaleon", "Aquí encontrarás productos naturales para tu salud y bienestar, tenemos línea de alimentos saludables y cosmética natural","",

            "Calle 100 # 100 - 20 Colombia",
            )

    }
}