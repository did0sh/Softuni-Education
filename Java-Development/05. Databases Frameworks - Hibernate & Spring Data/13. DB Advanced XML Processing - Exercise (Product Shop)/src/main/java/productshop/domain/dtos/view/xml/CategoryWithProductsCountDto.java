package productshop.domain.dtos.view.xml;

import productshop.domain.dtos.view.CategoryNameDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryWithProductsCountDto {

    @XmlElement(name = "category")
    private List<CategoryNameDto> categoryNameDtos;

    public CategoryWithProductsCountDto() {
    }

    public List<CategoryNameDto> getCategoryNameDtos() {
        return this.categoryNameDtos;
    }

    public void setCategoryNameDtos(List<CategoryNameDto> categoryNameDtos) {
        this.categoryNameDtos = categoryNameDtos;
    }
}
