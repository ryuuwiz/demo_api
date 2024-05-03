package id.ac.unpam.demo_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import id.ac.unpam.demo_api.model.Mahasiswa;
import id.ac.unpam.demo_api.service.MahasiswaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@Validated
public class MahasiswaController {

  @Autowired
  MahasiswaService mahasiswaService;

  @GetMapping("/mhs")
  public List<Mahasiswa> semuaMahasiswa() {
    return (List<Mahasiswa>) mahasiswaService.semua();
  }

  @GetMapping("/mhs/{id}")
  public ResponseEntity<Mahasiswa> satuMahasiswa(@PathVariable("id") Integer id) {
    Optional<Mahasiswa> mahasiswa = mahasiswaService.mahasiswaById(id);

    if (mahasiswa.isEmpty())
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    return new ResponseEntity<>(mahasiswa.get(), HttpStatus.OK);
  }

  @PostMapping("/mhs")
  public Mahasiswa tambahMahasiswa(@Valid @RequestBody Mahasiswa mahasiswa) {
    return mahasiswaService.simpan(mahasiswa);
  }

  @PutMapping("/mhs/{id}")
  public ResponseEntity<Mahasiswa> ubahMahasiswa(@PathVariable("id") Integer id,
      @Valid @RequestBody Mahasiswa mahasiswa) {
    Optional<Mahasiswa> data = mahasiswaService.mahasiswaById(id);

    if (data.isPresent()) {
      Mahasiswa _mahasiswa = data.get();
      _mahasiswa.setNim(mahasiswa.getNim());
      _mahasiswa.setNama(mahasiswa.getNama());
      _mahasiswa.setAlamat(mahasiswa.getAlamat());

      return new ResponseEntity<>(mahasiswaService.ubah(_mahasiswa), HttpStatus.OK);
    }

    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/mhs/{id}")
  public ResponseEntity<HttpStatus> hapusMahasiswa(@PathVariable("id") Integer id) {
    mahasiswaService.hapus(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
