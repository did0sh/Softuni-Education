function main(arr) {
    let result = new Map();
    for (let string of arr) {
        let args = string.split('|').filter(x => x !== '');
        let systemName = args[0].trim();
        let componentName = args[1].trim();
        let subcomponentName = args[2].trim();

        if(!result.has(systemName)){
            result.set(systemName, new Map());
            result.get(systemName).set(componentName, []);
            result.get(systemName).get(componentName).push(subcomponentName);
        } else {
            if(!result.get(systemName).has(componentName)){
                result.get(systemName).set(componentName, []);
                result.get(systemName).get(componentName).push(subcomponentName);
            } else {
                result.get(systemName).get(componentName).push(subcomponentName);
            }
        }
    }

    let systemsSorted = Array.from(result.keys()).sort((a,b) => sortSystems(a,b));

    for (let key of systemsSorted) {
        console.log(key);
        let componentsSorted = Array.from(result.get(key).keys()).sort((x,y) => sortComponents(key,x,y));

        for (let component of componentsSorted) {
            console.log(`|||${component}`);
            result.get(key).get(component).forEach(sub => console.log(`||||||${sub}`));
        }
    }

    function sortSystems(a,b) {
        if(result.get(a).size !== result.get(b).size){
            return result.get(b).size - result.get(a).size;
        } else {
            return a.toLowerCase().localeCompare(b);
        }
    }

    function sortComponents(system, x, y) {
        return result.get(system).get(y).length - result.get(system).get(x).length;
    }
}

main([`SULS | Main Site | Home Page`,
`SULS | Main Site | Login Page`,
`SULS | Main Site | Register Page`,
`SULS | Judge Site | Login Page`,
`SULS | Judge Site | Submittion Page`,
`Lambda | CoreA | A23`,
`SULS | Digital Site | Login Page`,
`Lambda | CoreB | B24`,
`Lambda | CoreA | A24`,
`Lambda | CoreA | A25`,
`Lambda | CoreC | C4`,
`Indice | Session | Default Storage`,
`Indice | Session | Default Security`]);