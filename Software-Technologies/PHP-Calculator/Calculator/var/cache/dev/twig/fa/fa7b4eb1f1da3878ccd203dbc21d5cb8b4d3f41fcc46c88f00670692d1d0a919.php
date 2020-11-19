<?php

/* @WebProfiler/Collector/router.html.twig */
class __TwigTemplate_ccdce11ac6a01c8c1770266db1f344e5bb6938727862fd66c4cf97a3eaabbfda extends Twig_Template
{
    public function __construct(Twig_Environment $env)
    {
        parent::__construct($env);

        // line 1
        $this->parent = $this->loadTemplate("@WebProfiler/Profiler/layout.html.twig", "@WebProfiler/Collector/router.html.twig", 1);
        $this->blocks = array(
            'toolbar' => array($this, 'block_toolbar'),
            'menu' => array($this, 'block_menu'),
            'panel' => array($this, 'block_panel'),
        );
    }

    protected function doGetParent(array $context)
    {
        return "@WebProfiler/Profiler/layout.html.twig";
    }

    protected function doDisplay(array $context, array $blocks = array())
    {
        $__internal_1ca615a7447b641b550b48f5856dbf3467ce5a3558a59edde7c6cbe84e90c2c1 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_1ca615a7447b641b550b48f5856dbf3467ce5a3558a59edde7c6cbe84e90c2c1->enter($__internal_1ca615a7447b641b550b48f5856dbf3467ce5a3558a59edde7c6cbe84e90c2c1_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", "@WebProfiler/Collector/router.html.twig"));

        $this->parent->display($context, array_merge($this->blocks, $blocks));
        
        $__internal_1ca615a7447b641b550b48f5856dbf3467ce5a3558a59edde7c6cbe84e90c2c1->leave($__internal_1ca615a7447b641b550b48f5856dbf3467ce5a3558a59edde7c6cbe84e90c2c1_prof);

    }

    // line 3
    public function block_toolbar($context, array $blocks = array())
    {
        $__internal_d15d5b7a47966ca8b2cb450420a266ec0cea4c731dd28b45828863d626a73842 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_d15d5b7a47966ca8b2cb450420a266ec0cea4c731dd28b45828863d626a73842->enter($__internal_d15d5b7a47966ca8b2cb450420a266ec0cea4c731dd28b45828863d626a73842_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "toolbar"));

        
        $__internal_d15d5b7a47966ca8b2cb450420a266ec0cea4c731dd28b45828863d626a73842->leave($__internal_d15d5b7a47966ca8b2cb450420a266ec0cea4c731dd28b45828863d626a73842_prof);

    }

    // line 5
    public function block_menu($context, array $blocks = array())
    {
        $__internal_6684f8978003bc51a9c91e55b7cf86c4729bdcf0381659bd1201f9c7ff58e106 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_6684f8978003bc51a9c91e55b7cf86c4729bdcf0381659bd1201f9c7ff58e106->enter($__internal_6684f8978003bc51a9c91e55b7cf86c4729bdcf0381659bd1201f9c7ff58e106_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "menu"));

        // line 6
        echo "<span class=\"label\">
    <span class=\"icon\">";
        // line 7
        echo twig_include($this->env, $context, "@WebProfiler/Icon/router.svg");
        echo "</span>
    <strong>Routing</strong>
</span>
";
        
        $__internal_6684f8978003bc51a9c91e55b7cf86c4729bdcf0381659bd1201f9c7ff58e106->leave($__internal_6684f8978003bc51a9c91e55b7cf86c4729bdcf0381659bd1201f9c7ff58e106_prof);

    }

    // line 12
    public function block_panel($context, array $blocks = array())
    {
        $__internal_c04f0609be28c17fb2203bd28c98a90a6a4d618b6c56f8ba044c5289a701ab48 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_c04f0609be28c17fb2203bd28c98a90a6a4d618b6c56f8ba044c5289a701ab48->enter($__internal_c04f0609be28c17fb2203bd28c98a90a6a4d618b6c56f8ba044c5289a701ab48_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "panel"));

        // line 13
        echo "    ";
        echo $this->env->getExtension('Symfony\Bridge\Twig\Extension\HttpKernelExtension')->renderFragment($this->env->getExtension('Symfony\Bridge\Twig\Extension\RoutingExtension')->getPath("_profiler_router", array("token" => (isset($context["token"]) ? $context["token"] : $this->getContext($context, "token")))));
        echo "
";
        
        $__internal_c04f0609be28c17fb2203bd28c98a90a6a4d618b6c56f8ba044c5289a701ab48->leave($__internal_c04f0609be28c17fb2203bd28c98a90a6a4d618b6c56f8ba044c5289a701ab48_prof);

    }

    public function getTemplateName()
    {
        return "@WebProfiler/Collector/router.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  73 => 13,  67 => 12,  56 => 7,  53 => 6,  47 => 5,  36 => 3,  11 => 1,);
    }

    public function getSource()
    {
        return "{% extends '@WebProfiler/Profiler/layout.html.twig' %}

{% block toolbar %}{% endblock %}

{% block menu %}
<span class=\"label\">
    <span class=\"icon\">{{ include('@WebProfiler/Icon/router.svg') }}</span>
    <strong>Routing</strong>
</span>
{% endblock %}

{% block panel %}
    {{ render(path('_profiler_router', { token: token })) }}
{% endblock %}
";
    }
}
