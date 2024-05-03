package id.ac.unpam.demo_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.ac.unpam.demo_api.model.Mahasiswa;

@Repository
public interface MahasiswaRepo extends JpaRepository<Mahasiswa, Integer> {
}
