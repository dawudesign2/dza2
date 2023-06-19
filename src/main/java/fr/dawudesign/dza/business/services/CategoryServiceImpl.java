package fr.dawudesign.dza.business.services;

import fr.dawudesign.dza.business.dtos.CategoryDTO;
import fr.dawudesign.dza.business.entities.Category;
import fr.dawudesign.dza.business.repositories.CategoryRepository;
import fr.dawudesign.dza.exeptions.ParametrizeMessageException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository repository;
    @Override
    public Iterable<CategoryDTO> findAll() {

        return repository.findAll()
                .stream()
                .map(CategoryDTO::fromEntity)
                .collect(Collectors.toList());
    }


    @Override
    public CategoryDTO findById(Long id) {
        return repository.findById(id)
                .map(CategoryDTO::fromEntity)
                .orElse(null);
    }

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        Category category = CategoryDTO.toEntity(categoryDTO);
        return CategoryDTO.fromEntity(repository.save(category));
    }

    @Override
    public CategoryDTO update(Long id, CategoryDTO categoryDTO) {
         if(repository.existsById(id)){
             Category category = CategoryDTO.toEntity(categoryDTO);
             return CategoryDTO.fromEntity(repository.save(category));
         } else {
             throw new ParametrizeMessageException(
                     HttpStatus.NOT_FOUND,
                     "category.entity.not.found",
                     "Category with id %s not found",
                     id
             );
         }
    }

    @Override
    public void deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ParametrizeMessageException(
                    HttpStatus.NOT_FOUND,
                    "category.entity.not.found",
                    "Category with id %s not found",
                    id
            );
        }
    }
}
