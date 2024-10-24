package de.westnordost.streetcomplete.screens.main.map

val themeLight = MapColors(
    earth = "#f3eacc",
    water = "#68d",
    waterShore = "#abe",
    green = "#c6ddaa",
    forest = "#a8c884",
    town = "#f3dacd",
    building = "rgb(204,214,238)",
    buildingOutline = "rgb(185,195,217)",
    pointBarrier = "#888",
    adminBoundary = "#e39",
    railway = "#99a",
    aeroway = "#fff",
    path = "#ca9",
    road = "#fff",
    roadOutline = "#ca9",
    pedestrian = "#f6eee6",
    motorway = "#fa8",
    motorwayOutline = "#a88",
    text = "#124",
    textOutline = "#fff",
    textWater = "#fff",
    textWaterOutline = "#349",
    privateOverlay = "#f3dacd",
    hillshadeLight = "hsl(220, 100%, 95%)",
    hillshadeShadow = "hsl(18, 100%, 40%)",
    onewayArrow = "#888",
)

val themeNight = MapColors(
    earth = "#2e2e48",
    water = "#002",
    waterShore = "#228",
    green = "#363054",
    forest = "#403962",
    town = "#3d364e",
    building = "rgba(41,92,92,0.8)",
    buildingOutline = "rgba(31,82,82,0.8)",
    pointBarrier = "#99f",
    adminBoundary = "#e72",
    railway = "#96c",
    aeroway = "#559",
    path = "#547",
    road = "#559",
    roadOutline = "#547",
    pedestrian = "#554e7e",
    motorway = "#669",
    motorwayOutline = "#99f",
    text = "#ccf",
    textOutline = "#2e2e48",
    textWater = "#2e2e48",
    textWaterOutline = "#ccf",
    privateOverlay = "#3d364e",
    hillshadeLight = "hsl(240, 30%, 50%)",
    hillshadeShadow = "hsl(240, 80%, 0%)",
    onewayArrow = "#ccf"
)

val themeDarkContrast = MapColors(
    earth = "#151525",
    water = "#000060",
    waterShore = "#228",
    green = "#375935",
    forest = "#293f28",
    town = "#000000",
    building = "rgba(33,77,77,0.7)",
    buildingOutline = "rgba(59,140,140,0.5)",
    pointBarrier = "#99f",
    adminBoundary = "#e72",
    railway = "#727",
    aeroway = "#559",
    path = "#668",
    road = "#559",
    roadOutline = "#99f",
    pedestrian = "#554e7e",
    motorway = "#669",
    motorwayOutline = "#99f",
    text = "#ccf",
    textOutline = "#2e2e48",
    textWater = "#2e2e48",
    textWaterOutline = "#aac",
    privateOverlay = "#3d364e",
    hillshadeLight = "hsl(240, 30%, 50%)",
    hillshadeShadow = "hsl(240, 80%, 0%)",
    onewayArrow = "#ccf"
)

fun rasterBackground(hideLabels: Boolean) = if (hideLabels)
    MapColors( // hide everything, not just labels
        earth = "rgba(0,0,0,0)",
        water = "rgba(0,0,0,0)",
        waterShore = "rgba(0,0,0,0)",
        green = "rgba(0,0,0,0)",
        forest = "rgba(0,0,0,0)",
        town = "rgba(0,0,0,0)",
        building = "rgba(0,0,0,0)",
        buildingOutline = "rgba(0,0,0,0)",
        pointBarrier = "rgba(0,0,0,0)",
        adminBoundary = "rgba(0,0,0,0)",
        railway = "rgba(0,0,0,0)",
        aeroway = "rgba(0,0,0,0)",
        path = "rgba(0,0,0,0)",
        road = "rgba(0,0,0,0)",
        roadOutline = "rgba(0,0,0,0)",
        pedestrian = "rgba(0,0,0,0)",
        motorway = "rgba(0,0,0,0)",
        motorwayOutline = "rgba(0,0,0,0)",
        text = "rgba(0,0,0,0)",
        textOutline = "rgba(0,0,0,0)",
        textWater = "rgba(0,0,0,0)",
        textWaterOutline = "rgba(0,0,0,0)",
        privateOverlay = "rgba(0,0,0,0)",
        hillshadeLight = "rgba(0,0,0,0)",
        hillshadeShadow = "rgba(0,0,0,0)",
        onewayArrow = "rgba(0,0,0,0)",
    )
else
    MapColors(
        earth = "rgba(0,0,0,0)",
        water = "rgba(0,0,0,0)",
        waterShore = "rgba(170,187,238,0.4)",
        green = "rgba(0,0,0,0)",
        forest = "rgba(0,0,0,0)",
        town = "rgba(0,0,0,0)",
        building = "rgba(204,214,238,0.2)",
        buildingOutline = "rgba(185,195,217,0.4)",
        pointBarrier = "#888",
        adminBoundary = "#e39",
        railway = "rgba(153,153,170,0.5)",
        aeroway = "#fff",
        path = "rgba(255,170,136,0.2)",
        road = "rgba(255,255,255,0.2)",
        roadOutline = "rgba(204,170,153,0.5)",
        pedestrian = "rgba(255,170,136,0.2)",
        motorway = "rgba(255,255,255,0.2)",
        motorwayOutline = "rgba(204,170,153,0.5)",
        text = "#124",
        textOutline = "#fff",
        textWater = "#fff",
        textWaterOutline = "#349",
        privateOverlay = "rgba(243,218,205,0.5)",
        hillshadeLight = "hsl(220, 100%, 95%)",
        hillshadeShadow = "hsl(18, 100%, 40%)",
        onewayArrow = "#888",
    )
