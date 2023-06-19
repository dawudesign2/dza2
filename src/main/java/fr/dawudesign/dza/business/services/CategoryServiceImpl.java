package fr.dawudesign.dza.business.services;

import fr.dawudesign.dza.business.dtos.CategoryDTO;
import fr.dawudesign.dza.business.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository repository;
    @Override
    public Iterable<CategoryDTO> findAll() {
        return null;
    }

    @Override
    public CategoryDTO findById(Long id) {
        return null;
    }

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        return null;
    }

    @Override
    public CategoryDTO update(Long id, CategoryDTO categoryDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
