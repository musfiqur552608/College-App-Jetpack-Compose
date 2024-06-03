package org.freedu.collegeapp.models

import okhttp3.Address

data class CollegeInfoModel(
    val name:String?="",
    val address: String ?= "",
    val desc: String?="",
    val websiteLink: String?="",
    val imageUrl: String?=""
)
