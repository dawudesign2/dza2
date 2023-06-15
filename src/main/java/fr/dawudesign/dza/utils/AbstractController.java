package fr.dawudesign.dza.utils;

import fr.dawudesign.dza.users.dtos.ProfileDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public interface AbstractController<T> {
    @GetMapping("/all")
    ResponseEntity<Iterable <T>> getAll();
    @GetMapping("/{id}")
    ResponseEntity<T> getById(@PathVariable Long id);
    @PostMapping("/add")
    ResponseEntity<T> save(@RequestBody T t);

    @PutMapping("/update/{id}")
    ResponseEntity<T> updateById(@PathVariable Long id, @RequestBody T t);

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Void> deleteById(@PathVariable Long id);
}
