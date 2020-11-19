<?php

/* @Twig/Exception/exception_full.html.twig */
class __TwigTemplate_3d774a7037b745a632f65ffdfb0cb9b3d21bf3276c75e4f291514621dc372862 extends Twig_Template
{
    public function __construct(Twig_Environment $env)
    {
        parent::__construct($env);

        // line 1
        $this->parent = $this->loadTemplate("@Twig/layout.html.twig", "@Twig/Exception/exception_full.html.twig", 1);
        $this->blocks = array(
            'head' => array($this, 'block_head'),
            'title' => array($this, 'block_title'),
            'body' => array($this, 'block_body'),
        );
    }

    protected function doGetParent(array $context)
    {
        return "@Twig/layout.html.twig";
    }

    protected function doDisplay(array $context, array $blocks = array())
    {
        $__internal_569c9bb5e74a2f3dd4f3755b1d0ff4c343ba8b9cfd750b2228b01e9ae28c55d6 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_569c9bb5e74a2f3dd4f3755b1d0ff4c343ba8b9cfd750b2228b01e9ae28c55d6->enter($__internal_569c9bb5e74a2f3dd4f3755b1d0ff4c343ba8b9cfd750b2228b01e9ae28c55d6_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", "@Twig/Exception/exception_full.html.twig"));

        $this->parent->display($context, array_merge($this->blocks, $blocks));
        
        $__internal_569c9bb5e74a2f3dd4f3755b1d0ff4c343ba8b9cfd750b2228b01e9ae28c55d6->leave($__internal_569c9bb5e74a2f3dd4f3755b1d0ff4c343ba8b9cfd750b2228b01e9ae28c55d6_prof);

    }

    // line 3
    public function block_head($context, array $blocks = array())
    {
        $__internal_cd8a68aba91d9a73fabbc06c6d2de866809f112f6fe9ab3d515675d0b617592b = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_cd8a68aba91d9a73fabbc06c6d2de866809f112f6fe9ab3d515675d0b617592b->enter($__internal_cd8a68aba91d9a73fabbc06c6d2de866809f112f6fe9ab3d515675d0b617592b_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "head"));

        // line 4
        echo "    <link href=\"";
        echo twig_escape_filter($this->env, $this->env->getExtension('Symfony\Bridge\Twig\Extension\HttpFoundationExtension')->generateAbsoluteUrl($this->env->getExtension('Symfony\Bridge\Twig\Extension\AssetExtension')->getAssetUrl("bundles/framework/css/exception.css")), "html", null, true);
        echo "\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />
";
        
        $__internal_cd8a68aba91d9a73fabbc06c6d2de866809f112f6fe9ab3d515675d0b617592b->leave($__internal_cd8a68aba91d9a73fabbc06c6d2de866809f112f6fe9ab3d515675d0b617592b_prof);

    }

    // line 7
    public function block_title($context, array $blocks = array())
    {
        $__internal_6802b983e9a820a47231a165031448c23a669ee5e2ca39229abc673321a3f78e = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_6802b983e9a820a47231a165031448c23a669ee5e2ca39229abc673321a3f78e->enter($__internal_6802b983e9a820a47231a165031448c23a669ee5e2ca39229abc673321a3f78e_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "title"));

        // line 8
        echo "    ";
        echo twig_escape_filter($this->env, $this->getAttribute((isset($context["exception"]) ? $context["exception"] : $this->getContext($context, "exception")), "message", array()), "html", null, true);
        echo " (";
        echo twig_escape_filter($this->env, (isset($context["status_code"]) ? $context["status_code"] : $this->getContext($context, "status_code")), "html", null, true);
        echo " ";
        echo twig_escape_filter($this->env, (isset($context["status_text"]) ? $context["status_text"] : $this->getContext($context, "status_text")), "html", null, true);
        echo ")
";
        
        $__internal_6802b983e9a820a47231a165031448c23a669ee5e2ca39229abc673321a3f78e->leave($__internal_6802b983e9a820a47231a165031448c23a669ee5e2ca39229abc673321a3f78e_prof);

    }

    // line 11
    public function block_body($context, array $blocks = array())
    {
        $__internal_6a8ae307793e2e43bfe85d6c689920c2eea1ef8dba25b0c5a5ee785981fe1044 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_6a8ae307793e2e43bfe85d6c689920c2eea1ef8dba25b0c5a5ee785981fe1044->enter($__internal_6a8ae307793e2e43bfe85d6c689920c2eea1ef8dba25b0c5a5ee785981fe1044_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "body"));

        // line 12
        echo "    ";
        $this->loadTemplate("@Twig/Exception/exception.html.twig", "@Twig/Exception/exception_full.html.twig", 12)->display($context);
        
        $__internal_6a8ae307793e2e43bfe85d6c689920c2eea1ef8dba25b0c5a5ee785981fe1044->leave($__internal_6a8ae307793e2e43bfe85d6c689920c2eea1ef8dba25b0c5a5ee785981fe1044_prof);

    }

    public function getTemplateName()
    {
        return "@Twig/Exception/exception_full.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  78 => 12,  72 => 11,  58 => 8,  52 => 7,  42 => 4,  36 => 3,  11 => 1,);
    }

    public function getSource()
    {
        return "{% extends '@Twig/layout.html.twig' %}

{% block head %}
    <link href=\"{{ absolute_url(asset('bundles/framework/css/exception.css')) }}\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />
{% endblock %}

{% block title %}
    {{ exception.message }} ({{ status_code }} {{ status_text }})
{% endblock %}

{% block body %}
    {% include '@Twig/Exception/exception.html.twig' %}
{% endblock %}
";
    }
}
