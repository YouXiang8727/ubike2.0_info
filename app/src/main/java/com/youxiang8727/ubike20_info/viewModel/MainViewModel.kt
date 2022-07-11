package com.youxiang8727.ubike20_info.viewModel

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.youxiang8727.ubike20_info.api.UbikeApiService
import com.youxiang8727.ubike20_info.model.UbikeResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val ubikeApiService: UbikeApiService
): ViewModel() {

    private val ubikeResponseMutableLiveData: MutableLiveData<List<UbikeResponse>> = MutableLiveData(null)
    val ubikeResponseLiveData = ubikeResponseMutableLiveData
}