package com.grupounoptresunal.kamaleon.data.models

import java.io.FileDescriptor

data class StoreInfo(
    var  id : String,
    var name : String,
    var description : String,
    var image : String? = null,
    var address : String,
    var lat : Double? = null,
    var lng : Double? = null

)
