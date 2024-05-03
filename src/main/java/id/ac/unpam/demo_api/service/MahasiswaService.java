package id.ac.unpam.demo_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.unpam.demo_api.model.Mahasiswa;
import id.ac.unpam.demo_api.repositories.MahasiswaRepo;

@Service
public class MahasiswaService {
  @Autowired
  MahasiswaRepo mhsRepo;

  public List<Mahasiswa> semua() {
    return mhsRepo.findAll();
  }

  public Optional<Mahasiswa> mahasiswaById(Integer id) {
    return mhsRepo.findById(id);
  }

  public Mahasiswa simpan(Mahasiswa data) {
    Mahasiswa mhs = new Mahasiswa();
    mhs.setNim(data.getNim());
    mhs.setNama(data.getNama());
    mhs.setAlamat(data.getAlamat());

    return mhsRepo.save(mhs);
  }

  public Mahasiswa ubah(Mahasiswa data) {
    return mhsRepo.save(data);
  }

  public void hapus(Integer id) {
    mhsRepo.deleteById(id);
  }
}
