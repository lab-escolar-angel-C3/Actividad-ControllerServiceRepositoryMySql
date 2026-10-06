package mx.edu.utez.angel.cursos.controller;

import java.util.*;
import lombok.RequiredArgsConstructor;
import mx.edu.utez.angel.cursos.entity.Curso;
import mx.edu.utez.angel.cursos.repository.CursoRepository;
import mx.edu.utez.angel.cursos.service.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
@RequiredArgsConstructor
public class CursoController {
    private final CursoService service;

    @GetMapping
    public List<Curso> listarTodo(){
        return service.obtenerTodo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> obtenerPorId(@PathVariable Long id) {
        Optional<Curso> curso = service.obtenerPorId(id);
        if (curso.isPresent()) {
            return ResponseEntity.ok(curso.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Curso guardar(@RequestBody Curso curso) {
        return service.guardar(curso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> actualizar(@PathVariable Long id, @RequestBody Curso cursoActualizado) {
        Optional<Curso> cursoExistente = service.obtenerPorId(id);

        if (cursoExistente.isPresent()) {
            Curso curso = cursoExistente.get();
            curso.setNombre(cursoActualizado.getNombre());
            curso.setProfesor(cursoActualizado.getProfesor());
            curso.setHoras(cursoActualizado.getHoras());
            return ResponseEntity.ok(service.guardar(curso));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
