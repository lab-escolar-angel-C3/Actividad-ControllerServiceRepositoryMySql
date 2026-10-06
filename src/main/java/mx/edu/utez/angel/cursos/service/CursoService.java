package mx.edu.utez.angel.cursos.service;

import lombok.RequiredArgsConstructor;
import mx.edu.utez.angel.cursos.entity.Curso;
import mx.edu.utez.angel.cursos.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class CursoService {
    private final CursoRepository repository;

    public List<Curso> obtenerTodo() {
        return repository.findAll();
    }

    public Optional<Curso> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Curso guardar(Curso curso) {
        return repository.save(curso);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
