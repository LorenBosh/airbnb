package com.example.airbnb.repository;

import com.example.airbnb.model.Host;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostRepository extends JpaRepository<Host,Long> {
}
