package com.nckim.domain.model

data class ImageModel (
    var id: Int,
    var author: String,
    var width: Int,
    var height: Int,
    var url: String,
    var download_url: String
)