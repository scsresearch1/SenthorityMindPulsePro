package com.mindpulse.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MindPulseApp()
        }
    }
}

private val Bg = Color(0xFFF5F7FA)
private val CardBg = Color.White
private val Blue = Color(0xFF2563EB)
private val Green = Color(0xFF16A34A)
private val Red = Color(0xFFE11D48)
private val Purple = Color(0xFF7C3AED)
private val Amber = Color(0xFFF59E0B)
private val TextDark = Color(0xFF111827)
private val TextMuted = Color(0xFF6B7280)

@Composable
fun SplashScreen(onFinish: () -> Unit) {
    LaunchedEffect(Unit) {
        delay(2200)
        onFinish()
    }

    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .background(Bg),
        contentAlignment = Alignment.Center,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "Mind Pulse Logo",
                modifier = Modifier.size(150.dp),
            )

            Spacer(Modifier.height(24.dp))

            Text(
                text = "Mind Pulse",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = TextDark,
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = "Measure. Understand. Optimize.",
                fontSize = 14.sp,
                color = TextMuted,
            )

            Spacer(Modifier.height(32.dp))

            CircularProgressIndicator(
                color = Blue,
                strokeWidth = 3.dp,
                modifier = Modifier.size(36.dp),
            )
        }
    }
}

@Composable
fun MindPulseApp() {
    var showSplash by remember { mutableStateOf(true) }
    var selected by remember { mutableIntStateOf(0) }

    if (showSplash) {
        SplashScreen {
            showSplash = false
        }
    } else {
        Scaffold(
            containerColor = Bg,
            bottomBar = {
                NavigationBar(containerColor = Color.White) {
                    navItems.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = selected == index,
                            onClick = { selected = index },
                            icon = { Icon(item.icon, item.title) },
                            label = { Text(item.title, fontSize = 11.sp) },
                        )
                    }
                }
            },
        ) { padding ->
            Box(Modifier.padding(padding)) {
                when (selected) {
                    0 -> DashboardScreen()
                    1 -> LiveMonitorScreen()
                    2 -> InsightsScreen()
                    3 -> TrendsScreen()
                    4 -> MoreScreen()
                }
            }
        }
    }
}

data class NavItem(val title: String, val icon: androidx.compose.ui.graphics.vector.ImageVector)

private val navItems =
    listOf(
        NavItem("Home", Icons.Default.Home),
        NavItem("Live", Icons.Default.Favorite),
        NavItem("Insights", Icons.Default.Insights),
        NavItem("Trends", Icons.Default.ShowChart),
        NavItem("Profile", Icons.Default.Person),
    )

@Composable
fun Page(title: String, content: @Composable ColumnScope.() -> Unit) {
    LazyColumn(
        modifier =
            Modifier
                .fillMaxSize()
                .background(Bg)
                .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp),
    ) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(R.drawable.logo),
                        contentDescription = "Mind Pulse Logo",
                        modifier = Modifier.size(32.dp),
                    )

                    Spacer(Modifier.width(8.dp))

                    Text(
                        title,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextDark,
                    )
                }

                Icon(Icons.Default.Notifications, null)
            }
        }
        item {
            Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
                content()
            }
        }
    }
}

@Composable
fun DashboardScreen() {
    Page("Mind Pulse") {
        StatusCard("Good Morning, Alex", "Your body and mind are in balance.", "87", "Good")

        SectionTitle("Today’s Snapshot")

        GridCards(
            listOf(
                Metric("Heart Rate", "72", "bpm", Red, "Good"),
                Metric("HRV", "54", "ms", Green, "Stable"),
                Metric("Stress Index", "32", "Low", Blue, "Low"),
                Metric("Recovery", "78", "%", Green, "Good"),
                Metric("Sleep", "7h 23m", "", Purple, "Good"),
                Metric("Cognitive Load", "28", "", Blue, "Optimal"),
            ),
        )

        SystemSummaryCard()
    }
}

@Composable
fun LiveMonitorScreen() {
    Page("Live Monitor") {
        Tabs(listOf("Heart", "Brain", "Body", "Activity"))

        LargeGraphCard(
            title = "Heart Rate",
            value = "72",
            unit = "bpm",
            color = Red,
            status = "Live",
        )

        LargeGraphCard(
            title = "HRV",
            value = "54",
            unit = "ms",
            color = Green,
            status = "Stable",
        )

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            SmallStat("Respiration Rate", "16.2", "/min", Blue, Modifier.weight(1f))
            SmallStat("Skin Temp.", "36.4", "°C", Purple, Modifier.weight(1f))
        }

        SignalCard()
    }
}

@Composable
fun InsightsScreen() {
    Page("Insights") {
        Tabs(listOf("Overview", "Physical", "Mental", "Emotional"))

        InsightHeroCard(
            title = "Cognitive Load & Neural Fatigue",
            value = "28",
            status = "Optimal",
            description = "Your brain activity is balanced. Sustained focus is achievable.",
        )

        InsightMetric("Physiological Stress Index", "32.5", "Low", Green)
        InsightMetric("Recovery Readiness", "78%", "Good", Green)
        InsightMetric("Sleep Stability", "82%", "Good", Purple)
        InsightMetric("Emotional Balance", "79%", "Stable", Blue)
    }
}

@Composable
fun TrendsScreen() {
    Page("Trends") {
        Tabs(listOf("1D", "7D", "30D", "90D"))

        TrendRow("Heart Rate", "72", "bpm", Red, "7D Avg")
        TrendRow("HRV", "54", "ms", Green, "7D Avg")
        TrendRow("Stress Index", "32", "Low", Blue, "7D Avg")
        TrendRow("Sleep Duration", "7h 23m", "", Purple, "7D Avg")
        TrendRow("Recovery", "78", "%", Green, "7D Avg")
        TrendRow("Cognitive Load", "28", "Good", Blue, "7D Avg")
    }
}

@Composable
fun MoreScreen() {
    var page by remember { mutableStateOf("Body") }

    Column(
        Modifier
            .fillMaxSize()
            .background(Bg),
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            listOf("Body", "Mind", "Sleep", "System", "Profile").forEach {
                FilterChip(
                    selected = page == it,
                    onClick = { page = it },
                    label = { Text(it) },
                )
            }
        }

        when (page) {
            "Body" -> BodySystemsScreen()
            "Mind" -> MindBrainScreen()
            "Sleep" -> SleepAnalysisScreen()
            "System" -> SystemStatusScreen()
            "Profile" -> ProfileReportsScreen()
        }
    }
}

@Composable
fun BodySystemsScreen() {
    Page("Body Systems") {
        Tabs(listOf("Cardio", "Respiratory", "Temperature", "Metabolic"))

        SystemDetailCard(
            title = "Cardiovascular Health",
            status = "Good",
            metrics =
                listOf(
                    "Heart Rate" to "72 bpm",
                    "HRV (RMSSD)" to "54 ms",
                    "Blood Oxygen (SpO₂)" to "98%",
                    "Pulse Pressure" to "38 mmHg",
                    "Blood Flow Index" to "2.1 L/min",
                    "Vascular Age" to "24 yrs",
                ),
        )
    }
}

@Composable
fun MindBrainScreen() {
    Page("Mind & Brain") {
        Tabs(listOf("Cognitive", "Emotional", "Focus", "Neural"))

        SystemDetailCard(
            title = "Cognitive Performance",
            status = "Good",
            metrics =
                listOf(
                    "Cognitive Load" to "28",
                    "Mental Energy" to "72%",
                    "Focus Readiness" to "81%",
                    "Attention Stability" to "76%",
                    "Processing Speed" to "1.08 s",
                    "Memory Recall" to "82%",
                ),
        )
    }
}

@Composable
fun SleepAnalysisScreen() {
    Page("Sleep Analysis") {
        StatusCard("Sleep Score", "Sleep recovery quality", "82", "Good")

        CardBox {
            Text("Sleep Stages", fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(12.dp))
            StageBar()
            Spacer(Modifier.height(16.dp))

            SleepRow("Deep Sleep", "1h 45m", "24%")
            SleepRow("REM Sleep", "1h 56m", "27%")
            SleepRow("Light Sleep", "3h 02m", "42%")
            SleepRow("Awake", "20m", "7%")
        }
    }
}

@Composable
fun SystemStatusScreen() {
    Page("System Status") {
        CardBox {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(R.drawable.band),
                    contentDescription = "Mind Pulse Band",
                    modifier = Modifier.size(64.dp),
                )

                Spacer(Modifier.width(12.dp))

                Column(Modifier.weight(1f)) {
                    Text(
                        "Mind Pulse Band",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                    )

                    Text(
                        "Connected • Firmware 1.2.4",
                        color = Green,
                        fontSize = 13.sp,
                    )
                }

                Text(
                    "85%",
                    color = Green,
                    fontWeight = FontWeight.Bold,
                )
            }
        }

        SystemLine("Signal Quality", "Excellent", "98%")
        SystemLine("BLE Link Stability", "Stable", "98%")
        SystemLine("Data Integrity", "Validated", "100%")
        SystemLine("Sensor Status", "Operational", "All sensors")
        SystemLine("Sync Status", "Just now", "Live")
        SystemLine("Wear Detection", "On Wrist", "Valid")
        SystemLine("Auto Calibration", "Up to date", "OK")
    }
}

@Composable
fun ProfileReportsScreen() {
    Page("Profile & Reports") {
        CardBox {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    Modifier
                        .size(56.dp)
                        .background(Blue.copy(alpha = 0.12f), CircleShape),
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(Icons.Default.Person, null, tint = Blue)
                }
                Spacer(Modifier.width(12.dp))
                Column {
                    Text("Alex Thompson", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    Text("Male • 29 yrs • 178 cm • 72 kg", color = TextMuted)
                }
            }
        }

        ReportItem("Daily Summary Report")
        ReportItem("Weekly Synergy Report")
        ReportItem("Monthly Performance Report")
        ReportItem("Recovery Report")
        ReportItem("Stress & Resilience Report")
        ReportItem("Export Health Data")
    }
}

@Composable
fun StatusCard(title: String, subtitle: String, value: String, status: String) {
    CardBox {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.weight(1f)) {
                Text(title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(subtitle, color = TextMuted, fontSize = 13.sp)
            }
            Box(contentAlignment = Alignment.Center) {
                CircularProgressIndicator(
                    progress = { 0.87f },
                    color = Green,
                    strokeWidth = 5.dp,
                    modifier = Modifier.size(64.dp),
                )
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(value, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Text(status, color = Green, fontSize = 11.sp)
                }
            }
        }
    }
}

@Composable
fun GridCards(metrics: List<Metric>) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        metrics.chunked(2).forEach { row ->
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                row.forEach {
                    MetricCard(it, Modifier.weight(1f))
                }
                if (row.size == 1) Spacer(Modifier.weight(1f))
            }
        }
    }
}

data class Metric(
    val title: String,
    val value: String,
    val unit: String,
    val color: Color,
    val status: String,
)

@Composable
fun MetricCard(metric: Metric, modifier: Modifier = Modifier) {
    CardBox(modifier) {
        Text(metric.title, color = TextDark, fontWeight = FontWeight.Medium, fontSize = 13.sp)
        Spacer(Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.Bottom) {
            Text(metric.value, fontWeight = FontWeight.Bold, fontSize = 26.sp)
            if (metric.unit.isNotBlank()) {
                Spacer(Modifier.width(4.dp))
                Text(metric.unit, color = TextMuted, fontSize = 12.sp)
            }
        }
        Spacer(Modifier.height(8.dp))
        MiniLineChart(metric.color)
        Text(metric.status, color = metric.color, fontSize = 12.sp)
    }
}

@Composable
fun LargeGraphCard(title: String, value: String, unit: String, color: Color, status: String) {
    CardBox {
        Row {
            Column(Modifier.weight(1f)) {
                Text(title, fontWeight = FontWeight.Bold)
                Row(verticalAlignment = Alignment.Bottom) {
                    Text(value, fontSize = 34.sp, fontWeight = FontWeight.Bold, color = color)
                    Spacer(Modifier.width(4.dp))
                    Text(unit, color = TextMuted)
                }
            }
            AssistChip(onClick = {}, label = { Text(status) })
        }
        Spacer(Modifier.height(12.dp))
        BigLineChart(color)
    }
}

@Composable
fun InsightHeroCard(title: String, value: String, status: String, description: String) {
    CardBox {
        Text(title, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(12.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.weight(1f)) {
                Text(value, fontSize = 36.sp, fontWeight = FontWeight.Bold)
                Text(status, color = Green, fontWeight = FontWeight.Medium)
                Spacer(Modifier.height(8.dp))
                Text(description, color = TextMuted, fontSize = 13.sp)
            }
            Icon(Icons.Default.Psychology, null, tint = Blue, modifier = Modifier.size(72.dp))
        }
    }
}

@Composable
fun InsightMetric(title: String, value: String, status: String, color: Color) {
    CardBox {
        Text(title, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.Bottom) {
            Text(value, fontWeight = FontWeight.Bold, fontSize = 28.sp)
            Spacer(Modifier.width(8.dp))
            Text(status, color = color)
        }
        Spacer(Modifier.height(8.dp))
        LinearProgressIndicator(
            progress = { 0.78f },
            color = color,
            trackColor = color.copy(alpha = 0.15f),
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Composable
fun TrendRow(title: String, value: String, unit: String, color: Color, note: String) {
    CardBox {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.weight(1f)) {
                Text(title, fontWeight = FontWeight.Bold)
                Row(verticalAlignment = Alignment.Bottom) {
                    Text(value, fontWeight = FontWeight.Bold, fontSize = 22.sp)
                    Spacer(Modifier.width(4.dp))
                    Text(unit, color = TextMuted)
                }
            }
            MiniLineChart(color, Modifier.width(100.dp).height(40.dp))
            Spacer(Modifier.width(8.dp))
            Text(note, color = TextMuted, fontSize = 12.sp)
        }
    }
}

@Composable
fun SystemDetailCard(title: String, status: String, metrics: List<Pair<String, String>>) {
    CardBox {
        Row {
            Column(Modifier.weight(1f)) {
                Text(title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text(status, color = Green, fontWeight = FontWeight.Medium)
            }
            Icon(Icons.Default.Favorite, null, tint = Blue, modifier = Modifier.size(54.dp))
        }

        Spacer(Modifier.height(12.dp))

        metrics.forEach {
            Row(
                Modifier.fillMaxWidth().padding(vertical = 6.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(it.first, color = TextMuted)
                Text(it.second, fontWeight = FontWeight.Bold, color = TextDark)
            }
        }
    }
}

@Composable
fun SystemSummaryCard() {
    CardBox {
        Text("Live System Status", fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Text("All systems normal", color = Green)
            Text("Signal Quality: Excellent", color = Green)
        }
    }
}

@Composable
fun SignalCard() {
    CardBox {
        Text("Signal Quality", fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Excellent", color = Green, fontWeight = FontWeight.Bold)
            Spacer(Modifier.weight(1f))
            repeat(7) {
                Box(
                    Modifier
                        .width(8.dp)
                        .height((12 + it * 3).dp)
                        .background(Green, RoundedCornerShape(4.dp)),
                )
                Spacer(Modifier.width(4.dp))
            }
        }
    }
}

@Composable
fun SystemLine(title: String, value: String, meta: String) {
    CardBox {
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Column {
                Text(title, fontWeight = FontWeight.Bold)
                Text(value, color = Green, fontSize = 13.sp)
            }
            Text(meta, color = TextDark, fontWeight = FontWeight.Medium)
        }
    }
}

@Composable
fun ReportItem(title: String) {
    CardBox {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.Description, null, tint = Blue)
            Spacer(Modifier.width(12.dp))
            Text(title, Modifier.weight(1f), fontWeight = FontWeight.Medium)
            Icon(Icons.Default.ChevronRight, null, tint = TextMuted)
        }
    }
}

@Composable
fun SmallStat(title: String, value: String, unit: String, color: Color, modifier: Modifier) {
    CardBox(modifier) {
        Text(title, fontWeight = FontWeight.Medium, fontSize = 13.sp)
        Spacer(Modifier.height(6.dp))
        Row(verticalAlignment = Alignment.Bottom) {
            Text(value, fontWeight = FontWeight.Bold, fontSize = 24.sp, color = color)
            Text(unit, color = TextMuted, fontSize = 12.sp)
        }
        MiniLineChart(color)
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(title, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = TextDark)
}

@Composable
fun Tabs(items: List<String>) {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items.forEachIndexed { index, item ->
            AssistChip(
                onClick = {},
                label = { Text(item) },
                colors =
                    AssistChipDefaults.assistChipColors(
                        containerColor = if (index == 0) Blue.copy(alpha = 0.1f) else Color.White,
                        labelColor = if (index == 0) Blue else TextMuted,
                    ),
            )
        }
    }
}

@Composable
fun CardBox(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = CardBg),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(18.dp),
    ) {
        Column(Modifier.padding(16.dp)) {
            content()
        }
    }
}

@Composable
fun MiniLineChart(color: Color, modifier: Modifier = Modifier.fillMaxWidth().height(34.dp)) {
    Canvas(modifier) {
        val points = listOf(0.7f, 0.5f, 0.58f, 0.45f, 0.65f, 0.55f, 0.75f, 0.62f)
        val path = Path()
        points.forEachIndexed { index, value ->
            val x = size.width * index / (points.size - 1)
            val y = size.height * (1f - value)
            if (index == 0) path.moveTo(x, y) else path.lineTo(x, y)
        }
        drawPath(path, color, style = Stroke(width = 3.dp.toPx(), cap = StrokeCap.Round))
    }
}

@Composable
fun BigLineChart(color: Color) {
    Canvas(Modifier.fillMaxWidth().height(160.dp)) {
        val values = listOf(0.45f, 0.55f, 0.48f, 0.7f, 0.62f, 0.74f, 0.58f, 0.82f, 0.66f, 0.72f)
        val path = Path()
        values.forEachIndexed { index, value ->
            val x = size.width * index / (values.size - 1)
            val y = size.height * (1f - value)
            if (index == 0) path.moveTo(x, y) else path.lineTo(x, y)
        }

        drawLine(Color.LightGray, Offset(0f, size.height * 0.25f), Offset(size.width, size.height * 0.25f))
        drawLine(Color.LightGray, Offset(0f, size.height * 0.5f), Offset(size.width, size.height * 0.5f))
        drawLine(Color.LightGray, Offset(0f, size.height * 0.75f), Offset(size.width, size.height * 0.75f))
        drawPath(path, color, style = Stroke(width = 4.dp.toPx(), cap = StrokeCap.Round))
    }
}

@Composable
fun StageBar() {
    Row(Modifier.fillMaxWidth().height(18.dp)) {
        Box(Modifier.weight(0.24f).fillMaxHeight().background(Blue, RoundedCornerShape(8.dp)))
        Box(Modifier.weight(0.27f).fillMaxHeight().background(Purple))
        Box(Modifier.weight(0.42f).fillMaxHeight().background(Color(0xFF60A5FA)))
        Box(Modifier.weight(0.07f).fillMaxHeight().background(Color(0xFFF472B6), RoundedCornerShape(8.dp)))
    }
}

@Composable
fun SleepRow(title: String, duration: String, percent: String) {
    Row(
        Modifier.fillMaxWidth().padding(vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(title, color = TextMuted)
        Text(duration, fontWeight = FontWeight.Bold)
        Text(percent, color = TextMuted)
    }
}
