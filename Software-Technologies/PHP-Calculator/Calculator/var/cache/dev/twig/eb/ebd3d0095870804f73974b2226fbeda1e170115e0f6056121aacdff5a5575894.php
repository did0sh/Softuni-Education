<?php

/* @Twig/Exception/traces.txt.twig */
class __TwigTemplate_a25fd774ba3cc1bd53a1ad6f1bf12a160a87d50baed04f797947c9b46ec5c74c extends Twig_Template
{
    public function __construct(Twig_Environment $env)
    {
        parent::__construct($env);

        $this->parent = false;

        $this->blocks = array(
        );
    }

    protected function doDisplay(array $context, array $blocks = array())
    {
        $__internal_67a5a866cc750b5f1031129814951ebe9a8fcdae4a724a1c058d6521667cf895 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_67a5a866cc750b5f1031129814951ebe9a8fcdae4a724a1c058d6521667cf895->enter($__internal_67a5a866cc750b5f1031129814951ebe9a8fcdae4a724a1c058d6521667cf895_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", "@Twig/Exception/traces.txt.twig"));

        // line 1
        if (twig_length_filter($this->env, $this->getAttribute((isset($context["exception"]) ? $context["exception"] : $this->getContext($context, "exception")), "trace", array()))) {
            // line 2
            $context['_parent'] = $context;
            $context['_seq'] = twig_ensure_traversable($this->getAttribute((isset($context["exception"]) ? $context["exception"] : $this->getContext($context, "exception")), "trace", array()));
            foreach ($context['_seq'] as $context["_key"] => $context["trace"]) {
                // line 3
                $this->loadTemplate("@Twig/Exception/trace.txt.twig", "@Twig/Exception/traces.txt.twig", 3)->display(array("trace" => $context["trace"]));
                // line 4
                echo "
";
            }
            $_parent = $context['_parent'];
            unset($context['_seq'], $context['_iterated'], $context['_key'], $context['trace'], $context['_parent'], $context['loop']);
            $context = array_intersect_key($context, $_parent) + $_parent;
        }
        
        $__internal_67a5a866cc750b5f1031129814951ebe9a8fcdae4a724a1c058d6521667cf895->leave($__internal_67a5a866cc750b5f1031129814951ebe9a8fcdae4a724a1c058d6521667cf895_prof);

    }

    public function getTemplateName()
    {
        return "@Twig/Exception/traces.txt.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  30 => 4,  28 => 3,  24 => 2,  22 => 1,);
    }

    public function getSource()
    {
        return "{% if exception.trace|length %}
{% for trace in exception.trace %}
{% include '@Twig/Exception/trace.txt.twig' with { 'trace': trace } only %}

{% endfor %}
{% endif %}
";
    }
}
