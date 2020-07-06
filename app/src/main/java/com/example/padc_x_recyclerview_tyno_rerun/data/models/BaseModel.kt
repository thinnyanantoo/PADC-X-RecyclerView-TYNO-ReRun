package com.example.padc_x_recyclerview_tyno_rerun.data.models

import com.example.padc_x_recyclerview_tyno_rerun.networks.dataagents.HttpUrlConnectionDataAgentImpl
import com.example.padc_x_recyclerview_tyno_rerun.networks.dataagents.NewsDataAgent
import com.example.padc_x_recyclerview_tyno_rerun.networks.dataagents.OkHttpUrlConnectionDataAgentImpl

abstract class BaseModel {
    val mDataAgent : NewsDataAgent = OkHttpUrlConnectionDataAgentImpl
}