package myapp.controller;

import filter.CharacterSetFilter;
import myapp.model.Product;
import myapp.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    IProductService productService;
    CharacterSetFilter characterSetFilter;
    @GetMapping("/")
    public String formHome(Model model){
        List<Product> productList= productService.findAll();
        model.addAttribute("products",productList);
        return "index";
    }
    @GetMapping("/product/create")
    public String formCreate(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }
    @PostMapping("/product/save")
    public String saveProduct(Product product, RedirectAttributes redirect){
        product.setId((int)Math.random()*10000);
        productService.saveProduct(product);
        redirect.addFlashAttribute("message","Lưu sản phẩm thành công");
        return "redirect:/";
    }
    @GetMapping("/product/{id}/edit")
    private String editForm(@PathVariable int id, Model model){
        model.addAttribute("product",productService.findProduct(id));
        return "edit";
    }
    @PostMapping("/product/update")
    private String updateProduct(Product product, RedirectAttributes redirect){
        productService.updateProduct(product.getId(),product);
        redirect.addFlashAttribute("message","Đã cập nhật thông tin sản phẩm mởi");
        return "redirect:/";
    }
    @GetMapping("/product/{id}/delete")
    private String deleteForm(@PathVariable int id, Model model
    ){
        model.addAttribute("product",productService.findProduct(id));
        return "delete";
    }
    @PostMapping("/product/delete")
    private String deleteProduct(Product product, RedirectAttributes redirect){
        productService.deleteProduct(product.getId());
        redirect.addFlashAttribute("message","Xóa thông tin sản phẩm mởi");
        return "redirect:/";
    }
    @GetMapping("/product/{id}/view")
   private String viewForm(@PathVariable int id, Model model){
        model.addAttribute("product",productService.findProduct(id));
        return "view";
    }


}
