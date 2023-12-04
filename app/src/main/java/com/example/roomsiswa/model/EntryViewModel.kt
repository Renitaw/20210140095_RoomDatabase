package com.example.roomsiswa.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.roomsiswa.Repositori.RepositoriSiswa
import com.example.roomsiswa.data.Siswa

class EntryViewModel(private  val repositoriSiswa: RepositoriSiswa): ViewModel(){
    /**
     * Berisi status Siswa saat ini
     */
    var UiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    /* Fungsi untuk memvalidasi input */
    private fun validasiInput(uiState: DetailSiswa = UiStateSiswa.detailSiswa): Boolean {
        return with(uiState) {
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }
        fun updateUiState(detailSiswa: DetailSiswa) {
            UiStateSiswa =
                UIStateSiswa(detailSiswa = detailSiswa, isEntryValid = validasiInput(detailSiswa))
        }
    /* Fungsi untuk menyimpan data yang di-entry */
        suspend fun saveSiswa() {
            if (validasiInput()) {
                repositoriSiswa.insertSiswa(UiStateSiswa.detailSiswa.toSiswa())
            }
        }
    }

/**
 * Mewakili status Ui untuk siswa
 */

data class DetailSiswa(
    val id: Int = 0,
    val nama: String = "",
    val alamat: String = "",
    val telpon: String = "",
)

data class UIStateSiswa(
    val detailSiswa: DetailSiswa = DetailSiswa(),
    val isEntryValid: Boolean = false
)


/* Fungsi untuk mengkonversi data input ke data dalam tabel sesuai jenis datanya */
fun DetailSiswa.toSiswa(): Siswa = Siswa(
    id = id,
    nama = nama,
    alamat = alamat,
    telpon = telpon
)

fun Siswa.toUistateSiswa(isEntryValid: Boolean = false): UIStateSiswa = UIStateSiswa(
    detailSiswa = this.toDetailSiswa(),
    isEntryValid = isEntryValid
)

fun Siswa.toDetailSiswa(): DetailSiswa = DetailSiswa(
    id = id,
    nama = nama,
    alamat = alamat,
    telpon = telpon
)