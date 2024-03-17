package com.example.Museums;

import com.example.Museums.hibernate.HibernateUtil;
import com.example.Museums.hibernate.Museums;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс контроллер отвечает на запросы через веб - браузеры
 */
@Controller
public class WebController {

    @GetMapping("/")
    private String getMainPage(Model model) {
        List<Museums> allMuseums = getMuseums();
        model.addAttribute("museums", allMuseums);
        return "main";
    }

    /**
     * Метод возвращает список музеев из БД
     */
    public synchronized List<Museums> getMuseums() {
        Transaction transaction = null;
        List<Museums> museums = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            museums = session.createQuery("from Museums", Museums.class).list();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return museums;
    }
    }
