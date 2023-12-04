package com.example.roomsiswa.ui.theme.Halaman

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.roomsiswa.R
import com.example.roomsiswa.model.HomeViewModel
import com.example.roomsiswa.model.PenyediaViewModel
import com.example.roomsiswa.navigasi.DestinasiNavigasi

object DestinasiHome : DestinasiNavigasi {
    override val route = "home"
    override val titleRes = R.string.app_name
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigateToItemEntry: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = androidx.lifecycle.viewmodel.compose.viewModel(factory = PenyediaViewModel.Factory)
){

}