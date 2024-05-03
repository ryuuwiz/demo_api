package id.ac.unpam.demo_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_mhs")
public class Mahasiswa {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(length = 11, nullable = false, unique = true)
  @NotNull
  @NotEmpty
  private String nim;

  @Column(length = 30, nullable = false)
  @NotNull
  @NotEmpty
  private String nama;

  @Column(length = 100, nullable = false)
  @NotNull
  @NotEmpty
  private String alamat;
}
