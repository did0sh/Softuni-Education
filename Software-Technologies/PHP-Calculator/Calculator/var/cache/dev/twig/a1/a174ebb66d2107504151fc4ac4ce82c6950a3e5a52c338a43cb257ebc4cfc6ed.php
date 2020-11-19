<?php

/* base.html.twig */
class __TwigTemplate_8d494d9efff19771e94448874806a98354d2d5055b519bfdab5cb0b26f40ea87 extends Twig_Template
{
    public function __construct(Twig_Environment $env)
    {
        parent::__construct($env);

        $this->parent = false;

        $this->blocks = array(
            'title' => array($this, 'block_title'),
            'stylesheets' => array($this, 'block_stylesheets'),
            'body_id' => array($this, 'block_body_id'),
            'header' => array($this, 'block_header'),
            'body' => array($this, 'block_body'),
            'main' => array($this, 'block_main'),
            'javascripts' => array($this, 'block_javascripts'),
        );
    }

    protected function doDisplay(array $context, array $blocks = array())
    {
        $__internal_d311cb87dcf927446321a9ac026f9e1210e01924d75c6c7ffa243da217784faa = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_d311cb87dcf927446321a9ac026f9e1210e01924d75c6c7ffa243da217784faa->enter($__internal_d311cb87dcf927446321a9ac026f9e1210e01924d75c6c7ffa243da217784faa_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", "base.html.twig"));

        // line 6
        echo "<!DOCTYPE html>
<html lang=\"en-US\">
<head>
    <meta charset=\"UTF-8\"/>
    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"/>
    <title>";
        // line 11
        $this->displayBlock('title', $context, $blocks);
        echo "</title>
    ";
        // line 12
        $this->displayBlock('stylesheets', $context, $blocks);
        // line 16
        echo "    <link rel=\"icon\" type=\"image/x-icon\" href=\"";
        echo twig_escape_filter($this->env, $this->env->getExtension('Symfony\Bridge\Twig\Extension\AssetExtension')->getAssetUrl("favicon.ico"), "html", null, true);
        echo "\"/>
</head>

<body id=\"";
        // line 19
        $this->displayBlock('body_id', $context, $blocks);
        echo "\">

";
        // line 21
        $this->displayBlock('header', $context, $blocks);
        // line 39
        echo "
<div class=\"container body-container\">
    ";
        // line 41
        $this->displayBlock('body', $context, $blocks);
        // line 48
        echo "</div>


";
        // line 51
        $this->displayBlock('javascripts', $context, $blocks);
        // line 57
        echo "
</body>
</html>
";
        
        $__internal_d311cb87dcf927446321a9ac026f9e1210e01924d75c6c7ffa243da217784faa->leave($__internal_d311cb87dcf927446321a9ac026f9e1210e01924d75c6c7ffa243da217784faa_prof);

    }

    // line 11
    public function block_title($context, array $blocks = array())
    {
        $__internal_ccf15aa7ecbf8ce187b20afaacf0987c67312a2bb4e87672a836c1c81031e0aa = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_ccf15aa7ecbf8ce187b20afaacf0987c67312a2bb4e87672a836c1c81031e0aa->enter($__internal_ccf15aa7ecbf8ce187b20afaacf0987c67312a2bb4e87672a836c1c81031e0aa_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "title"));

        echo "Calculator";
        
        $__internal_ccf15aa7ecbf8ce187b20afaacf0987c67312a2bb4e87672a836c1c81031e0aa->leave($__internal_ccf15aa7ecbf8ce187b20afaacf0987c67312a2bb4e87672a836c1c81031e0aa_prof);

    }

    // line 12
    public function block_stylesheets($context, array $blocks = array())
    {
        $__internal_abe7ea0a66fe317c9239966ba980df0566a886a07650206ce6b96255f557334e = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_abe7ea0a66fe317c9239966ba980df0566a886a07650206ce6b96255f557334e->enter($__internal_abe7ea0a66fe317c9239966ba980df0566a886a07650206ce6b96255f557334e_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "stylesheets"));

        // line 13
        echo "        <link rel=\"stylesheet\" href=\"";
        echo twig_escape_filter($this->env, $this->env->getExtension('Symfony\Bridge\Twig\Extension\AssetExtension')->getAssetUrl("css/style.css"), "html", null, true);
        echo "\">
        <link rel=\"stylesheet\" href=\"";
        // line 14
        echo twig_escape_filter($this->env, $this->env->getExtension('Symfony\Bridge\Twig\Extension\AssetExtension')->getAssetUrl("css/bootstrap-datetimepicker.min.css"), "html", null, true);
        echo "\">
    ";
        
        $__internal_abe7ea0a66fe317c9239966ba980df0566a886a07650206ce6b96255f557334e->leave($__internal_abe7ea0a66fe317c9239966ba980df0566a886a07650206ce6b96255f557334e_prof);

    }

    // line 19
    public function block_body_id($context, array $blocks = array())
    {
        $__internal_27989311549a4b9b4b06cafc3d27dc85ace31eb7d5bc42f166673a8259f9fe4f = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_27989311549a4b9b4b06cafc3d27dc85ace31eb7d5bc42f166673a8259f9fe4f->enter($__internal_27989311549a4b9b4b06cafc3d27dc85ace31eb7d5bc42f166673a8259f9fe4f_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "body_id"));

        
        $__internal_27989311549a4b9b4b06cafc3d27dc85ace31eb7d5bc42f166673a8259f9fe4f->leave($__internal_27989311549a4b9b4b06cafc3d27dc85ace31eb7d5bc42f166673a8259f9fe4f_prof);

    }

    // line 21
    public function block_header($context, array $blocks = array())
    {
        $__internal_adc49f32228568f10fa4c21425895e1f57b9c474694fe8d46fb06d6c7e8ce568 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_adc49f32228568f10fa4c21425895e1f57b9c474694fe8d46fb06d6c7e8ce568->enter($__internal_adc49f32228568f10fa4c21425895e1f57b9c474694fe8d46fb06d6c7e8ce568_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "header"));

        // line 22
        echo "    <header>
        <div class=\"navbar navbar-default navbar-static-top\" role=\"navigation\">
            <div class=\"container\">
                <div class=\"navbar-header\">
                    <a href=\"";
        // line 26
        echo $this->env->getExtension('Symfony\Bridge\Twig\Extension\RoutingExtension')->getPath("index");
        echo "\" class=\"navbar-brand\">CALCULATOR</a>

                    <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">
                        <span class=\"icon-bar\"></span>
                        <span class=\"icon-bar\"></span>
                        <span class=\"icon-bar\"></span>
                    </button>
                </div>

            </div>
        </div>
    </header>
";
        
        $__internal_adc49f32228568f10fa4c21425895e1f57b9c474694fe8d46fb06d6c7e8ce568->leave($__internal_adc49f32228568f10fa4c21425895e1f57b9c474694fe8d46fb06d6c7e8ce568_prof);

    }

    // line 41
    public function block_body($context, array $blocks = array())
    {
        $__internal_b4ec28909be32eeec1e91b9881ba724f64ca5ab2f0c9de67dd39acad1034f98d = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_b4ec28909be32eeec1e91b9881ba724f64ca5ab2f0c9de67dd39acad1034f98d->enter($__internal_b4ec28909be32eeec1e91b9881ba724f64ca5ab2f0c9de67dd39acad1034f98d_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "body"));

        // line 42
        echo "        <div class=\"row\">
            <div id=\"main\" class=\"col-sm-9\">
                ";
        // line 44
        $this->displayBlock('main', $context, $blocks);
        // line 45
        echo "            </div>
        </div>
    ";
        
        $__internal_b4ec28909be32eeec1e91b9881ba724f64ca5ab2f0c9de67dd39acad1034f98d->leave($__internal_b4ec28909be32eeec1e91b9881ba724f64ca5ab2f0c9de67dd39acad1034f98d_prof);

    }

    // line 44
    public function block_main($context, array $blocks = array())
    {
        $__internal_72c50116619982c41fb83cbcb5645147f382ecc0fc7e87238fb01f85372868bf = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_72c50116619982c41fb83cbcb5645147f382ecc0fc7e87238fb01f85372868bf->enter($__internal_72c50116619982c41fb83cbcb5645147f382ecc0fc7e87238fb01f85372868bf_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "main"));

        
        $__internal_72c50116619982c41fb83cbcb5645147f382ecc0fc7e87238fb01f85372868bf->leave($__internal_72c50116619982c41fb83cbcb5645147f382ecc0fc7e87238fb01f85372868bf_prof);

    }

    // line 51
    public function block_javascripts($context, array $blocks = array())
    {
        $__internal_00811d27231bcffcbefaff78c5e8117b663bf883a5e958161a03011861bc78ad = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_00811d27231bcffcbefaff78c5e8117b663bf883a5e958161a03011861bc78ad->enter($__internal_00811d27231bcffcbefaff78c5e8117b663bf883a5e958161a03011861bc78ad_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "javascripts"));

        // line 52
        echo "    <script src=\"";
        echo twig_escape_filter($this->env, $this->env->getExtension('Symfony\Bridge\Twig\Extension\AssetExtension')->getAssetUrl("js/jquery-2.2.4.min.js"), "html", null, true);
        echo "\"></script>
    <script src=\"";
        // line 53
        echo twig_escape_filter($this->env, $this->env->getExtension('Symfony\Bridge\Twig\Extension\AssetExtension')->getAssetUrl("js/moment.min.js"), "html", null, true);
        echo "\"></script>
    <script src=\"";
        // line 54
        echo twig_escape_filter($this->env, $this->env->getExtension('Symfony\Bridge\Twig\Extension\AssetExtension')->getAssetUrl("js/bootstrap.js"), "html", null, true);
        echo "\"></script>
    <script src=\"";
        // line 55
        echo twig_escape_filter($this->env, $this->env->getExtension('Symfony\Bridge\Twig\Extension\AssetExtension')->getAssetUrl("js/bootstrap-datetimepicker.min.js"), "html", null, true);
        echo "\"></script>
";
        
        $__internal_00811d27231bcffcbefaff78c5e8117b663bf883a5e958161a03011861bc78ad->leave($__internal_00811d27231bcffcbefaff78c5e8117b663bf883a5e958161a03011861bc78ad_prof);

    }

    public function getTemplateName()
    {
        return "base.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  205 => 55,  201 => 54,  197 => 53,  192 => 52,  186 => 51,  175 => 44,  166 => 45,  164 => 44,  160 => 42,  154 => 41,  134 => 26,  128 => 22,  122 => 21,  111 => 19,  102 => 14,  97 => 13,  91 => 12,  79 => 11,  69 => 57,  67 => 51,  62 => 48,  60 => 41,  56 => 39,  54 => 21,  49 => 19,  42 => 16,  40 => 12,  36 => 11,  29 => 6,);
    }

    public function getSource()
    {
        return "{#
   This is the base template used as the application layout which contains the
   common elements and decorates all the other templates.
   See http://symfony.com/doc/current/book/templating.html#template-inheritance-and-layouts
#}
<!DOCTYPE html>
<html lang=\"en-US\">
<head>
    <meta charset=\"UTF-8\"/>
    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"/>
    <title>{% block title %}Calculator{% endblock %}</title>
    {% block stylesheets %}
        <link rel=\"stylesheet\" href=\"{{ asset('css/style.css') }}\">
        <link rel=\"stylesheet\" href=\"{{ asset('css/bootstrap-datetimepicker.min.css') }}\">
    {% endblock %}
    <link rel=\"icon\" type=\"image/x-icon\" href=\"{{ asset('favicon.ico') }}\"/>
</head>

<body id=\"{% block body_id %}{% endblock %}\">

{% block header %}
    <header>
        <div class=\"navbar navbar-default navbar-static-top\" role=\"navigation\">
            <div class=\"container\">
                <div class=\"navbar-header\">
                    <a href=\"{{ path('index') }}\" class=\"navbar-brand\">CALCULATOR</a>

                    <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">
                        <span class=\"icon-bar\"></span>
                        <span class=\"icon-bar\"></span>
                        <span class=\"icon-bar\"></span>
                    </button>
                </div>

            </div>
        </div>
    </header>
{% endblock %}

<div class=\"container body-container\">
    {% block body %}
        <div class=\"row\">
            <div id=\"main\" class=\"col-sm-9\">
                {% block main %}{% endblock %}
            </div>
        </div>
    {% endblock %}
</div>


{% block javascripts %}
    <script src=\"{{ asset('js/jquery-2.2.4.min.js') }}\"></script>
    <script src=\"{{ asset('js/moment.min.js') }}\"></script>
    <script src=\"{{ asset('js/bootstrap.js') }}\"></script>
    <script src=\"{{ asset('js/bootstrap-datetimepicker.min.js') }}\"></script>
{% endblock %}

</body>
</html>
";
    }
}
